package swingingpool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class SwaggyFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private JTabbedPane pan = new JTabbedPane(); 
    private JPanel panJinglePodcast = new JPanel();
    //Déclaration de la barre de menu
    private JMenuBar menuBar = new JMenuBar();                
    //Déclaration des choix et sous choix sur le menu
    private JMenu menu1 = new JMenu("Fichier");
    private JMenu menu2 = new JMenu("Edition");
    private JMenu menu4 = new JMenu("Look & Feel");
    private JMenu menu3 = new JMenu("Aide");           
    //Déclaration des éléments du menu
    private JMenuItem item1 = new JMenuItem("Ouvrir");
    private JMenuItem item2 = new JMenuItem("Quitter");
    private JMenuItem item5= new JMenuItem("Centre d'aide");
    private JMenuItem item6 = new JMenuItem ("A propos");
    //Checkbox dans le menu
    private JCheckBoxMenuItem jcmi1 = new JCheckBoxMenuItem("Choix 1");
    private JCheckBoxMenuItem jcmi2 = new JCheckBoxMenuItem("Choix 2");
	
	
	public SwaggyFrame(){
	    this.setTitle("#incom!ng in da place !");

	    this.setSize(400, 100);
	    this.setLocationRelativeTo(null);               
     
	    build();

	    this.setContentPane(pan);               
	    this.setVisible(true);
	}


	private void build(){
	    buildMenuBar();
	    buildTabbedPane();
	}
	

	private void buildMenuBar() {
	    this.setJMenuBar(menuBar);
	    this.menuBar.add(menu1);
	    this.menuBar.add(menu2);
	    this.menuBar.add(menu4);
	    this.menuBar.add(menu3);
	    this.menu1.add(item1);
	    this.menu1.add(item2);
	    this.menu2.add(jcmi1);
	    this.menu2.add(jcmi2);
	    this.menu3.add(item5);
	    this.menu3.add(item6);
	    
	    //this.menu4.add(UIManager.getCrossPlatformLookAndFeelClassName());
	    //this.menu4.add(UIManager.getSystemLookAndFeelClassName());
	    
	    final ButtonGroup groupLookAndFeel = new ButtonGroup();

        for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            final JRadioButtonMenuItem item = new JRadioButtonMenuItem(
                    info.getName());
            groupLookAndFeel.add(item);
            item.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(final ActionEvent e) {
                	System.out.println(e.getActionCommand());
					updateLookAndFeel(e.getActionCommand());
                }
            });
            menu4.add(item);
        }
	    /*try { 
	    	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); 
	    } catch (UnsupportedLookAndFeelException e) {} 
	      catch (ClassNotFoundException e) {} 
	      catch (InstantiationException e) {} 
	      catch(IllegalAccessException e) {}*/
	}

	private void buildTabbedPane(){
		this.getContentPane().add(pan);
		this.pan.add("Jingles",panJinglePodcast);

		URL dir_url = SwaggyFrame.class.getClassLoader().getResource("swingingpool/res/jinglesEmission");
		File dir = null;
		try {
			dir = new File(dir_url.toURI());
		} catch (URISyntaxException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		String[] files = dir.list();
		for(String s : files){
	        JButton button = new JButton(s);
	        button.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e)
	            {
	                //Execute when button is pressed
	                System.out.println("You clicked the button "+s);
	                URL dir_url = ClassLoader.getSystemResource("swingingpool/res/jinglesEmission/"+s);
	                AudioStream as = null;
					try {
						as = new AudioStream (dir_url.openStream());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					AudioPlayer.player.start(as);  
	            }
	        });
	        this.panJinglePodcast.add(button);
		}
		

		// Load the directory as a resource
		/*URL dir_url = ClassLoader.getSystemResource("swingingpool/res");
		// Turn the resource into a File object
		File dir = null;
		try {
			dir = new File(dir_url.toURI());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// List the directory
		String[] files = dir.list();
		for(String s : files)
			this.panJinglePodcast.add(new JLabel(s));*/
		//System.out.println(url.getPath());
	}

	
	private void updateLookAndFeel(final String LOOKANDFEEL) {
        try {
            for (final LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if (LOOKANDFEEL.equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (final UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
        } catch (final InstantiationException e) {
            e.printStackTrace();
        } catch (final IllegalAccessException e) {
            e.printStackTrace();
        }

        SwingUtilities.updateComponentTreeUI(this);
        this.pack();

    }

	
}
