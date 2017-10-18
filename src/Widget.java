import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class Widget extends ApplicationFrame {

    public Widget( String applicationTitle , String chartTitle ) {
        super( applicationTitle );
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

        dataset.addValue( 1.0 , normal , montag );
        dataset.addValue( 3.0 , normal , dienstag );
        dataset.addValue( 2.5 , normal , mittwoch );
        dataset.addValue( 5.0 , normal , donnerstag );
        dataset.addValue( 7.0 , normal , freitag );
        dataset.addValue( 5.0 , normal , samstag );

        dataset.addValue( 2.0 , nacht , montag );
        dataset.addValue( 3.0 , nacht , dienstag );
        dataset.addValue( 2.5 , nacht , mittwoch );
        dataset.addValue( 5.0 , nacht , donnerstag );
        dataset.addValue( 7.0 , nacht , freitag );
        dataset.addValue( 5.0 , nacht , samstag );

        dataset.addValue( 2.0 , tag , montag );
        dataset.addValue( 3.0 , tag , dienstag );
        dataset.addValue( 2.5 , tag , mittwoch );
        dataset.addValue( 5.0 , tag , donnerstag );
        dataset.addValue( 7.0 , tag , freitag );
        dataset.addValue( 5.0 , tag , samstag );


        return dataset;
    }

    public static void main( String[ ] args ) {
        Widget chart = new Widget("Einnahmen/Zeit",
                "Verteilung der Einnahmen");
        chart.pack( );
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible( true );
    }
}