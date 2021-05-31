package com.much12.citlib;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.anychart.AnyChart;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Column;
import com.anychart.enums.HoverMode;

import java.security.MessageDigest;
import java.util.List;

public class LibraryController {
    public String encryptMD5(String textoencrypt) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] bytes = textoencrypt.getBytes();

            digest.update(bytes);
            bytes = digest.digest();

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                String h = Integer.toHexString(0xFF & bytes[i]);

                if (h.length() < 2) {
                    h = "0" + h;
                }

                stringBuilder.append(h);
            }

            return stringBuilder.toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public ANRequest.GetRequestBuilder getAndroidNetworking(String url) {
        return AndroidNetworking.get(url);
    }

    public ANRequest.PostRequestBuilder postAndroidNetworking(String url) {
        return AndroidNetworking.post(url);
    }

    public Cartesian generateChart(String title, String yAxisTitle, String xAxisTitle, List<DataEntry> dataEntries) {
        Cartesian cartesian = AnyChart.column();
        Column column = cartesian.column(dataEntries);

        cartesian.animation(true).title(title).yScale().minimum(0d);
        cartesian.interactivity().hoverMode(HoverMode.BY_X);
        cartesian.yAxis(0).title(yAxisTitle);
        cartesian.xAxis(0).title(xAxisTitle);

        return cartesian;
    }
}
