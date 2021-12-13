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
    XYSeries dados_seriesA;
    XYSeries dados_seriesB;

    LineAndPointFormatter Format_SerieA;
    LineAndPointFormatter Format_SerieB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plot = findViewById(R.id.plot);

         dados_seriesA = new SimpleXYSeries(
                Arrays.asList(Vendas.pedidos), SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, getString(R.string.serieA));


         dados_seriesB = new SimpleXYSeries(
                Arrays.asList(Vendas.entregas), SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, getString(R.string.SerieB));


        Format_SerieA = new LineAndPointFormatter(Color.RED, Color.GREEN, Color.WHITE, null);

        Format_SerieB = new LineAndPointFormatter(Color.YELLOW, Color.GRAY, Color.BLUE, null);

        Format_SerieB.getLinePaint().setPathEffect(new DashPathEffect(new float[]{
                PixelUtils.dpToPix(20),
                PixelUtils.dpToPix(15)}, 0));

        Format_SerieA.setInterpolationParams(new CatmullRomInterpolator.Params(10, CatmullRomInterpolator.Type.Centripetal));
        Format_SerieB.setInterpolationParams(new CatmullRomInterpolator.Params(10, CatmullRomInterpolator.Type.Centripetal));

        plot.addSeries(dados_seriesA, Format_SerieA);
        plot.addSeries(dados_seriesB, Format_SerieB);


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
