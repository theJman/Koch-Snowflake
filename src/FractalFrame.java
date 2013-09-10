import java.awt.Color;

import javax.swing.JFrame;

/**
 * 
 */

/**
 * @author JeremyLittel
 *
 */
public class FractalFrame extends JFrame {
	//snowflake drawing panel
	private SnowflakePanel snowflakePanel;
	//options panel
	private OptionsPanel optionsPanel;
	
	/**
	 * Creates a new Fractal frame.
	 */
	public FractalFrame(){
		setLayout(null);
		setBounds(500, 100, 500, 450);
		setResizable(false);
		setTitle("Snowflake");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		snowflakePanel = new SnowflakePanel();
		add(snowflakePanel);
		snowflakePanel.setBounds(0, 0, 425, 450);
		
		optionsPanel = new OptionsPanel(snowflakePanel);
		optionsPanel.setBounds(425, 0, 75, 450);
		add(optionsPanel);
		
	}
	/**
	 * Opens the frame
	 */
	public void open(){
		setVisible(true);

	}
	
	
}
