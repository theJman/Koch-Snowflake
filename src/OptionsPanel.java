import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * 
 */

/**
 * @author JeremyLittel
 *
 */
public class OptionsPanel extends JPanel {
	// spinner to select order
	private JSpinner spinner;
	//panel to dram on
	private SnowflakePanel drawPanel;
	
	/**
	 * Creates a new options panel that handels user input and interacts with the Snowflake drawing panel
	 * @param panel Snowflake panel to use to draw fractal
	 */
	public OptionsPanel(SnowflakePanel panel){
		this.drawPanel = panel;
		setBackground(Color.blue);
		spinner = new JSpinner(new SpinnerNumberModel(0, 0, 2, 1));
		add(spinner);
		spinner.setBounds(10, 20, 65, 40);
		setBorder(BorderFactory.createLineBorder(Color.black));
		spinner.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				drawPanel.setOrder((int)spinner.getValue());
			}
		});
	}
}
