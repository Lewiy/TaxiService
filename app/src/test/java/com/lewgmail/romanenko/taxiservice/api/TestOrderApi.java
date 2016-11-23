package com.lewgmail.romanenko.taxiservice.api;

import com.lewgmail.romanenko.taxiservice.model.api.UserServices;
import com.lewgmail.romanenko.taxiservice.model.dataManager.ManagerOrderApiDrivCust;
import com.lewgmail.romanenko.taxiservice.model.pojo.MarkOrder;
import com.lewgmail.romanenko.taxiservice.model.pojo.OrderStatus;
import com.lewgmail.romanenko.taxiservice.model.pojo.Token;
import com.lewgmail.romanenko.taxiservice.presenter.BasePresenter;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.mockwebserver.Dispatcher;
import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;
import com.squareup.okhttp.mockwebserver.RecordedRequest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import rx.Scheduler;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.plugins.RxAndroidSchedulersHook;
import rx.schedulers.Schedulers;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Lev on 20.11.2016.
 */

public class TestOrderApi extends BaseTest {

    private Token token;
    private MockWebServer server = new MockWebServer();
    ;
    private com.google.gson.stream.JsonReader jsonReader;
    private UserServices service;
    private BasePresenter basePresenter = new BasePresenter();
    ;
    private ManagerOrderApiDrivCust manager = new ManagerOrderApiDrivCust(basePresenter);
    ;

    @Before
    public void beforeTest() throws Exception {

        // Не вэдома хрэнь, але пока без неї ніяк

        RxAndroidPlugins.getInstance().registerSchedulersHook(new RxAndroidSchedulersHook() {
            @Override
            public Scheduler getMainThreadScheduler() {
                return Schedulers.immediate();
            }
        });

        /////




        // Schedule some responses.
        //server.enqueue(new MockResponse().setBody("sup, bra?"));
        // server.enqueue(new MockResponse().setBody("yo dog"));
        // Start the server.
        server.start(8080);
        final Dispatcher dispatch = new Dispatcher() {

            @Override
            public MockResponse dispatch(RecordedRequest request) throws InterruptedException {
                if (request.getPath().equals("/order/121")) {
                    return new MockResponse().setResponseCode(200).setBody("{\n" +
                            "  \"orderId\" : 121,\n" +
                            "  \"startTime\" : \"DateTime\",\n" +
                            "  \"startPoint\" : \"ул. лоховская 12\",\n" +
                            "  \"endPoint\" : \"ул. лоховская 13\",\n" +
                            "  \"status\" : \"DONE\",\n" +
                            "  \"customer\" :{\n" +
                            "    \"customerId\" : 123531,\n" +
                            "    \"name\" : \"Пупсик\"\n" +
                            "  },\n" +
                            "  \"taxiDriver\":{\n" +
                            "    \"taxiDriverId\" : 642134,\n" +
                            "    \"name\" : \"пупсовод\"\n" +
                            "  },\n" +
                            "  \"price\" : 12,\n" +
                            "  \"additionalRequirements\" : [\n" +
                            "    {\"id\" : 1253,\n" +
                            "      \"name\" : \"Розовые ушки у водителя\",\n" +
                            "      \"description\" : \"Водитель должен быть с розовыми ушками на голове\"\n" +
                            "    }]\n" +
                            "}");
                } else {
                    if (request.getPath().equals("/order/95/status")) {
                        return new MockResponse().setResponseCode(200).setBody("lol");
                    } else {
                        return new MockResponse().setResponseCode(404);
                    }
                }

            }
        };
        server.setDispatcher(dispatch);
        HttpUrl baseUrl = server.url(serverAdress);

    }

    @Test
    public void getSpecificOrderId() throws Exception {


        //////////////////////      //test Error//////////////////////////

        manager.loadOrderId(125);

        // Request
        RecordedRequest request = server.takeRequest();
        assertEquals("GET /order/125 HTTP/1.1", request.getRequestLine());
        assertEquals("application/json", request.getHeader("Content-Type"));
        assertEquals("21334sfg23", request.getHeader("Authorization"));
        TimeUnit.SECONDS.sleep(3);
        // Testing errors
        assertEquals("HTTP 404 OK", basePresenter.getResponseMsg());


        //////////////////    /// test data///////////////////////////////////
        manager.loadOrderId(121);
        TimeUnit.SECONDS.sleep(3);
        // Request
        request = server.takeRequest();
        assertEquals("GET /order/121 HTTP/1.1", request.getRequestLine());
        assertEquals("application/json", request.getHeader("Content-Type"));
        assertEquals("21334sfg23", request.getHeader("Authorization"));
        TimeUnit.SECONDS.sleep(3);
        // Received data
        assertEquals(121, basePresenter.getOrderSpecificId().getOrderId());
        assertEquals("Водитель должен быть с розовыми ушками на голове",
                basePresenter.getOrderSpecificId().getAdditionalRequirements().get(0).getDescription());
        assertEquals("пупсовод", basePresenter.getOrderSpecificId().getTaxiDriver().getName());

    }

    @Test
    public void acceptRefuseDoneOrder() throws Exception {

        MarkOrder markOrder = new MarkOrder();
        markOrder.setUserId(100);
        markOrder.setType(OrderStatus.ACCEPTED.toString());
        manager.acceptRefuseDoneOrder(95, markOrder);
        /////////////////////Test Error////////////////////////////
        RecordedRequest request = server.takeRequest();
        assertEquals("application/json; charset=UTF-8", request.getHeader("Content-Type"));
        assertEquals("21334sfg23", request.getHeader("Authorization"));
        assertEquals("PUT /order/95/status HTTP/1.1", request.getRequestLine());
        assertEquals("{\n" +
                "  \"userId\" : \"95\",\n" +
                "  \"type\" : \"DONE\"\n" +
                "}", request.getBody());
        //  TimeUnit.SECONDS.sleep(3);
        /////////////////////Test Data////////////////////////////
        //assertEquals("HTTP/1.1 200 OK", basePresenter.getResponseMsg());


    }
    @After
    public void afterTest() throws Exception {

        server.shutdown();
        RxAndroidPlugins.getInstance().reset();
    }
}
