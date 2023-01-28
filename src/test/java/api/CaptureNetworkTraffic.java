package api;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v106.network.Network;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CaptureNetworkTraffic {

    DevTools devTools;

    public CaptureNetworkTraffic setUpDevTool(WebDriver driver) {
        devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        return this;
    }

    public List<String> captureHttpRequestsContain(String text) {
        List<String> request = new ArrayList<>();

        devTools.addListener(Network.requestWillBeSent(),
                entry -> {
                    if (entry.getRequest().getUrl().contains(text)
                            && !entry.getRequest().getUrl().contains("google")
                            && !entry.getRequest().getUrl().contains("/themes/")
                            && !entry.getRequest().getUrl().contains("assets")
                            && !entry.getRequest().getUrl().contains(".png")
                            && !entry.getRequest().getUrl().contains(".js")
                    ) {
                        request.add(entry.getRequest().getMethod());
                        request.add(entry.getRequest().getUrl());
                    }
                });

        return request;
    }

    public List<String> captureHttpResponsesContain(String text) {
        List<String> response = new ArrayList<>();

        devTools.addListener(Network.responseReceived(),
                entry -> {
                    if (entry.getResponse().getUrl().contains(text)
                            && !entry.getResponse().getUrl().contains("google")
                            && !entry.getResponse().getUrl().contains("/themes/")
                            && !entry.getResponse().getUrl().contains("assets")
                            && !entry.getResponse().getUrl().contains(".png")
                    ) {
                        response.add(entry.getResponse().getStatus().toString());
                        response.add(entry.getResponse().getStatusText());
                        response.add(entry.getResponse().getUrl());
                        response.add(entry.getResponse().getResponseTime().toString());
                    }
                });

        return response;
    }
}