package ducksim;

import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MakeDuckDialog extends JDialog {

    // Fields

    // Duck panel
    private final JPanel duckPanel = new JPanel();
    private final JLabel duckLabel = new JLabel("Duck");
    private final String[] duckStrings = {"Mallard", "Redhead", "Rubber", "Decoy", "Goose"};
    private final JComboBox duckOptions = new JComboBox(duckStrings);

    //Bling panel
    private final JPanel blingPanel = new JPanel();
    private final JButton starincreaseButton = new JButton("+");
    private final JButton stardecreaseButton = new JButton("-");
    private final JButton moonincreaseButton = new JButton("+");
    private final JButton moondecreaseButton = new JButton("-");
    private final JButton crossincreaseButton = new JButton("+");
    private final JButton crossdecreaseButton = new JButton("-");
    private final JLabel starLabel = new JLabel("  Star");
    private final JLabel moonLabel = new JLabel("  Moon");
    private final JLabel crossLabel = new JLabel("  Cross");
    private final JLabel starCountLabel = new JLabel("0");
    private final JLabel moonCountLabel = new JLabel("0");
    private final JLabel crossCountLabel = new JLabel("0");


    // Button panel
    private final JPanel buttonPanel = new JPanel();
    private final JButton okayButton = new JButton("Okay");
    private final JButton cancelButton = new JButton("Cancel");

    // Stored Data
    private String duckType = "Mallard";
    private int crossCount = 0;
    private int starCount = 0;
    private int moonCount = 0;

    // Constructor
    public MakeDuckDialog(DuckSimModel model, DuckSimView view) {

        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        GridLayout layout = new GridLayout(3, 4);

        // add duck panel
        duckPanel.add(duckLabel);
        duckOptions.addActionListener(e -> {
            JComboBox cb = (JComboBox) e.getSource();
            duckType = (String) cb.getSelectedItem();
        });
        duckPanel.add(duckOptions);
        this.add(duckPanel);

        //add bling panel
        blingPanel.setLayout(layout);
        blingPanel.add(starLabel);
        blingPanel.add(starCountLabel);
        blingPanel.add(starincreaseButton);
        blingPanel.add(stardecreaseButton);
        blingPanel.add(moonLabel);
        blingPanel.add(moonCountLabel);
        blingPanel.add(moonincreaseButton);
        blingPanel.add(moondecreaseButton);
        blingPanel.add(crossLabel);
        blingPanel.add(crossCountLabel);
        blingPanel.add(crossincreaseButton);
        blingPanel.add(crossdecreaseButton);

        starincreaseButton.addActionListener(e -> {
            if (starCount + crossCount + moonCount < 3) {starCount++;}
            starCountLabel.setText(String.valueOf(starCount));
        });

        stardecreaseButton.addActionListener(e -> {
            if (starCount > 0) {starCount = starCount -1;}
            starCountLabel.setText(String.valueOf(starCount));
        });

        moonincreaseButton.addActionListener(e -> {
            if (starCount + crossCount + moonCount < 3) {moonCount++;}
            moonCountLabel.setText(String.valueOf(moonCount));
        });

        moondecreaseButton.addActionListener(e -> {
            if (moonCount > 0) {moonCount = moonCount - 1;}
            moonCountLabel.setText(String.valueOf(moonCount));
        });

        crossincreaseButton.addActionListener(e -> {
            if (starCount + crossCount + moonCount < 3) {crossCount++;}
            crossCountLabel.setText(String.valueOf(crossCount));
        });

        crossdecreaseButton.addActionListener(e -> {
            if (crossCount > 0) {crossCount--;}
            crossCountLabel.setText(String.valueOf(crossCount));
        });

        this.add(blingPanel);

        // add button panel
        cancelButton.addActionListener(e -> {
            this.dispose();
        });
        buttonPanel.add(cancelButton);
        okayButton.addActionListener(e -> {
            // makeDuckDialog
            Duck duck;
            DuckFactory factory = DuckFactory.getInstance();

            duck = factory.createDuck(duckType,starCount,moonCount,crossCount);

            if (duck != null) {
                model.addNewDuck(duck);
            }
            view.repaint();
            this.dispose();
        });
        buttonPanel.add(okayButton);
        this.add(buttonPanel);
    }

    // Public Methods
    public String getDuckType() {
        return duckType;
    }
}
