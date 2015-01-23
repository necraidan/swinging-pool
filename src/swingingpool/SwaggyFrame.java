package swingingpool;

import java.awt.Color;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

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


	private void build() {
	    buildMenuBar();
	    buildTabbedPane();
	}
	

	private void buildMenuBar() {
	    this.setJMenuBar(menuBar);
	    this.menuBar.add(menu1);
	    this.menuBar.add(menu2);
	    this.menuBar.add(menu3);
	    this.menu1.add(item1);
	    this.menu1.add(item2);
	    this.menu2.add(jcmi1);
	    this.menu2.add(jcmi2);
	    this.menu3.add(item5);
	    this.menu3.add(item6);
	}

	private void buildTabbedPane() {
		this.getContentPane().add(pan);
		this.pan.add("Jingles",panJinglePodcast);
		URL url = SwaggyFrame.class.getResource("res/batterdie.mp3");
		this.panJinglePodcast.add(new JButton(""+url));
		//System.out.println(url.getPath());
	}

}
