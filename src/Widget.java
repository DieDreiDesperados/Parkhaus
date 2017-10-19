import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import java.util.ArrayList;

public class Widget extends ApplicationFrame {
    private ArrayList<Double[]> arrayList;



    public Widget( String applicationTitle , String chartTitle ) {
        super( applicationTitle );
        gesamtBesucherCounter = 0;
        JFreeChart barChart = ChartFactory.createBarChart3D(
                chartTitle,
                "Zeit in Tagen",
                "Einnahmen in Euro",
                createDataset(),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel( barChart );
        chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );
        setContentPane( chartPanel );
    }
    public Widget( String applicationTitle , String chartTitle, ArrayList<Double[]> arrayList ) {
        super( applicationTitle );
        gesamtBesucherCounter = 0;
        this.arrayList = arrayList;
        JFreeChart barChart = ChartFactory.createBarChart3D(
                chartTitle,
                "Zeit in Tagen",
                "Einnahmen in Euro",
                createDataset(),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel( barChart );
        JLabel input;
        input = new JLabel("Gesamtbesucher: " + gesamtBesucherCounter);
        input.setSize(200, 200);
        input.setLocation(425, 250);
        chartPanel.add(input);
        chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );
        setContentPane( chartPanel );
        setLayout(null);

    }


    private CategoryDataset createDataset( ) {
        final String montag = "Montag";
        final String dienstag = "Dienstag";
        final String mittwoch = "Mittwoch";
        final String donnerstag = "Donnerstag";
        final String freitag = "Freitag";
        final String samstag = "Samstag";
        final String normal = "Standard Ticket";
        final String nacht = "Nacht Ticket";
        final String tag = "Tages Ticket";
        final DefaultCategoryDataset dataset =
                new DefaultCategoryDataset( );
        double monday_ein_norm = 0.0;
        double tuesday_ein_norm = 0.0;
        double wednesday_ein_norm = 0.0;
        double thursday_ein_norm = 0.0;
        double friday_ein_norm = 0.0;
        double saturday_ein_norm = 0.0;

        double monday_ein_tag = 0.0;
        double tuesday_ein_tag = 0.0;
        double wednesday_ein_tag = 0.0;
        double thursday_ein_tag = 0.0;
        double friday_ein_tag = 0.0;
        double saturday_ein_tag = 0.0;

        double monday_ein_nacht = 0.0;
        double tuesday_ein_nacht = 0.0;
        double wednesday_ein_nacht = 0.0;
        double thursday_ein_nacht = 0.0;
        double friday_ein_nacht = 0.0;
        double saturday_ein_nacht = 0.0;


        for(Double[] array: arrayList){
            int letzteAnfrageBesucherCounter = 0;

            if (array[2].equals(1.0)) {
                if(array[1].equals(1.0)){
                    monday_ein_norm += array[0];
                }
                else if(array[1].equals(2.0)){
                    tuesday_ein_norm += array[0];
                }
                else if(array[1].equals(3.0)){
                    wednesday_ein_norm += array[0];
                }
                else if(array[1].equals(4.0)){
                    thursday_ein_norm += array[0];
                }
                else if(array[1].equals(5.0)){
                    friday_ein_norm += array[0];
                }
                else if(array[1].equals(6.0)){
                    saturday_ein_norm += array[0];
                }

            } else if (array[2].equals(2.0)) {
                if(array[1].equals(1.0)){
                    monday_ein_nacht += array[0];
                }
                else if(array[1].equals(2.0)){
                    tuesday_ein_nacht += array[0];
                }
                else if(array[1].equals(3.0)){
                    wednesday_ein_nacht += array[0];
                }
                else if(array[1].equals(4.0)){
                    thursday_ein_nacht += array[0];
                }
                else if(array[1].equals(5.0)){
                    friday_ein_nacht += array[0];
                }
                else if(array[1].equals(6.0)){
                    saturday_ein_nacht += array[0];
                }

            } else if (array[2].equals(3.0)) {
                if(array[1].equals(1.0)){
                    monday_ein_tag += array[0];
                }
                else if(array[1].equals(2.0)){
                    tuesday_ein_tag += array[0];
                }
                else if(array[1].equals(3.0)){
                    wednesday_ein_tag += array[0];
                }
                else if(array[1].equals(4.0)){
                    thursday_ein_tag += array[0];
                }
                else if(array[1].equals(5.0)){
                    friday_ein_tag += array[0];
                }
                else if(array[1].equals(6.0)){
                    saturday_ein_tag += array[0];
                }

                letzteAnfrageBesucherCounter++;

            }
        }

        dataset.addValue(monday_ein_norm, normal, montag );
        dataset.addValue(monday_ein_tag, tag, montag );
        dataset.addValue(monday_ein_nacht, nacht, montag );

        dataset.addValue(tuesday_ein_norm, normal, dienstag );
        dataset.addValue(tuesday_ein_tag, tag, dienstag );
        dataset.addValue(tuesday_ein_nacht, nacht, dienstag );

        dataset.addValue(wednesday_ein_norm, normal, mittwoch );
        dataset.addValue(wednesday_ein_tag, tag, mittwoch );
        dataset.addValue(wednesday_ein_nacht, nacht, mittwoch );

        dataset.addValue(thursday_ein_norm, normal, donnerstag );
        dataset.addValue(thursday_ein_tag, tag, donnerstag );
        dataset.addValue(thursday_ein_nacht, nacht, donnerstag );

        dataset.addValue(friday_ein_norm, normal, freitag );
        dataset.addValue(friday_ein_tag, tag, freitag );
        dataset.addValue(friday_ein_nacht, nacht, freitag );

        dataset.addValue(saturday_ein_norm, normal, samstag );
        dataset.addValue(saturday_ein_tag, tag, samstag );
        dataset.addValue(saturday_ein_nacht, nacht, samstag );

        return dataset;
    }


}