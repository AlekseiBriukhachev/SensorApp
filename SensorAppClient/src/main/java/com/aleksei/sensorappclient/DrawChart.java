package com.aleksei.sensorappclient;

import com.aleksei.sensorappclient.dto.MeasurementDTO;
import com.aleksei.sensorappclient.dto.MeasurementResponse;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DrawChart {
    public static void main(String[] args) {
        List<Double> temperatures = getTemperatureFromSensor();
        drawChart(temperatures);
    }

    private static void drawChart(List<Double> temperatures) {
        double[] xData = IntStream.range(0, temperatures.size()).asDoubleStream().toArray();
        double[] yData = temperatures.stream().mapToDouble(x -> x).toArray();
        XYChart chart = QuickChart.getChart("Temperatures", "X", "Y", "temperature", xData, yData);
        new SwingWrapper(chart).displayChart();
    }

    private static List<Double> getTemperatureFromSensor() {
        final RestTemplate restTemplate = new RestTemplate();
        final String url = "http://localhost:8080/measurements";
        MeasurementResponse response = restTemplate.getForObject(url, MeasurementResponse.class);
        if (response == null || response.getMeasurements() == null){
            return Collections.emptyList();
        }
        return response.getMeasurements().stream()
                .map(MeasurementDTO::getValue)
                .collect(Collectors.toList());
    }
}
