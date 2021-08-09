package lk.sliit.kiddieblocksapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

public class PerformanceActivity extends Activity
{
    public ImageView ivBack;
    public GraphView graph;
    public DataPoint array[];
    public int yValues[] = new int[] {4,6,3,4,5,10,11,2,7,2,1,6};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_performance);

        initialize();
        eventHandler();
    }


    public void initialize()
    {
        ivBack = (ImageView) findViewById(R.id.iv_backPerformance);
        graph = (GraphView) findViewById(R.id.graph);

        array = new DataPoint[12];

        initGraph();
        initDataPoints();
    }

    public void eventHandler()
    {
        drawGraph();

        ivBack.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });
    }

    public void initGraph()
    {
        graph.setTitle("Performance Evaluation");
        graph.setBackgroundColor(getResources().getColor(R.color.white));
        graph.setTitleTextSize(40);

        // set manual X bounds
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(0);
        graph.getViewport().setMaxX(12);

        // set manual Y bounds
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(0);
        graph.getViewport().setMaxY(12);
    }

    public void initDataPoints()
    {
        for (int i = 0; i < 12; i++)
        {
            array[i] = new DataPoint(i+1, yValues[i]);
        }
    }

    public void drawGraph()
    {
        BarGraphSeries<DataPoint> series = new BarGraphSeries<DataPoint>(array);
        graph.addSeries(series);

        series.setValueDependentColor(new ValueDependentColor<DataPoint>()
        {
            @Override
            public int get(DataPoint data)
            {
                return Color.rgb((int) data.getX()*255/4, (int) Math.abs(data.getY()*255/6), 100);
            }
        });

        series.setSpacing(5);
        series.setDrawValuesOnTop(true);
        series.setValuesOnTopColor(Color.parseColor("#1976D2"));
    }
}
