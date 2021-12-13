package app.grafico.appgraficoxy.view;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.androidplot.util.PixelUtils;
import com.androidplot.xy.CatmullRomInterpolator;
import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYGraphWidget;
import com.androidplot.xy.XYPlot;
import com.androidplot.xy.XYSeries;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.Arrays;

import app.grafico.appgraficoxy.R;
import app.grafico.appgraficoxy.model.Vendas;

public class MainActivity extends AppCompatActivity {

    private XYPlot plot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plot = findViewById(R.id.plot);

        XYSeries series1 = new SimpleXYSeries(
                Arrays.asList(Vendas.pedidos), SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Series1");


        XYSeries series2 = new SimpleXYSeries(
                Arrays.asList(Vendas.entregas), SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Series2");


        LineAndPointFormatter series1Format = new LineAndPointFormatter(Color.RED, Color.GREEN, Color.WHITE, null);

        LineAndPointFormatter series2Format = new LineAndPointFormatter(Color.YELLOW, Color.GRAY, Color.BLUE, null);

        series2Format.getLinePaint().setPathEffect(new DashPathEffect(new float[]{
                PixelUtils.dpToPix(20),
                PixelUtils.dpToPix(15)}, 0));

        series1Format.setInterpolationParams(new CatmullRomInterpolator.Params(10, CatmullRomInterpolator.Type.Centripetal));
        series2Format.setInterpolationParams(new CatmullRomInterpolator.Params(10, CatmullRomInterpolator.Type.Centripetal));

        plot.addSeries(series1, series1Format);
        plot.addSeries(series2, series2Format);


        plot.getGraph().getLineLabelStyle(XYGraphWidget.Edge.BOTTOM).setFormat(new Format() {
            @Override
            public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
                int i = Math.round(((Number) obj).floatValue());
                return toAppendTo.append(Vendas.quantidadePedidos[i]);
            }
            @Override
            public Object parseObject(String source, ParsePosition pos) {
                return null;
            }
        });
    }

}
