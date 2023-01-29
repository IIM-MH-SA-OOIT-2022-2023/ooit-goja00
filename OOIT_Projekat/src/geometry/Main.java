package geometry;

import java.awt.EventQueue;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JToggleButton;
import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.MouseMotionAdapter;
import java.util.HashMap;
import java.util.List;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultListModel;
import java.awt.GridLayout;
import java.util.*;
public class Main extends JFrame {
	

	private JPanel contentPane;
	private PnlDrawing canvas;
	private DlgRectangle dlgrec;
	private DlgCircle dlgcir;
	private DlgDonut dlgdon;
	boolean twoPoints=false;
	Point nextPoint;
	private DlgDodaj dlgdod;
	private DefaultListModel dlm = new DefaultListModel();
	int brojac=0;
	private DlgPoint dlgp;
	DlgLine dlgl;
	HashMap<String,Integer> a=new HashMap<String,Integer>();
	Point previousPoint;
	private DlgCircleM dlgcirm;
	private DlgRectangleM dlgrecm;
	private DlgDonutM dlgdonm;
	
	
	
	public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm)
	{
        List<Map.Entry<String, Integer> > list =
               new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());
 
       
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
         
        
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
    
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					
					Main frame = new Main();
					frame.setVisible(true);

						
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 835, 501);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		canvas=new PnlDrawing();
		canvas.setBorder(BorderFactory.createLineBorder(Color.black));
		contentPane.add(canvas,BorderLayout.CENTER);
		
		
		JToggleButton tglbtnPoint = new JToggleButton("Point");
		
		panel.add(tglbtnPoint);
		
		JToggleButton tglbtnLine = new JToggleButton("Line");
		
		panel.add(tglbtnLine);
		
		JToggleButton tglbtnCircle = new JToggleButton("Circle");
		panel.add(tglbtnCircle);
		
		JToggleButton tglbtnRectangle = new JToggleButton("Rectangle");
		panel.add(tglbtnRectangle);
		
		JToggleButton tglbtnDonut = new JToggleButton("Donut");
		panel.add(tglbtnDonut);
		
		JToggleButton tglbtnSelect = new JToggleButton("Select");
		panel.add(tglbtnSelect);
		
		JToggleButton tglbtnDelete = new JToggleButton("Delete");
		panel.add(tglbtnDelete);
		
		JLabel koordinata = new JLabel("0,0");
		contentPane.add(koordinata, BorderLayout.SOUTH);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JList list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel_2.add(list, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.SOUTH);
		
		JButton btnDodaj = new JButton("Dodaj pravougaonik");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dlgdod=new DlgDodaj();
				dlgdod.setVisible(true);
				
				if(dlgdod.check)
				{
					brojac++;
					Rectangle r =new Rectangle(new Point(Integer.parseInt(dlgdod.textFieldX.getText()),Integer.parseInt(dlgdod.textFieldY.getText())),
							Integer.parseInt(dlgdod.textFieldWidth.getText()),Integer.parseInt(dlgdod.textFieldHeight.getText()));
					
					dlm.add(0,"Pravougaonik " + brojac + "--->"+r.area());
					list.setModel(dlm);
					a.put("Pravougaonik " + brojac, r.area());
				}
				
			}
		});
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		panel_3.add(btnDodaj);
		
		JButton btnIzbrisi = new JButton("Izbrisi pravougaonik");
		btnIzbrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(list.isSelectionEmpty()==false)
				{
					int res = JOptionPane.showConfirmDialog(null, 
					         "Da li ste sigurni da zelite da obrisete?", 
					         "Brisanje", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(res==JOptionPane.YES_OPTION)
					{
						int index=list.getSelectedIndex();
						dlm.remove(index);
						list.setModel(dlm);
					}
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Niste izabrali pravougaonik!", "Greska!", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		panel_3.add(btnIzbrisi);
		
		JButton btnSort = new JButton("Sortiraj");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(list.getModel().getSize()==0)
				{
					JOptionPane.showMessageDialog(null, "Nema pravouganika u listi!!", "Greska!", JOptionPane.WARNING_MESSAGE);
				}
				else
				{
				
				dlm.removeAllElements();
				list.setModel(dlm);
				HashMap<String,Integer> novi=sortByValue(a);
				
				for (Map.Entry<String, Integer> en :
		             novi.entrySet()) 
				{
					dlm.add(0,en.getKey() + "--->"+en.getValue());
					
				}
				
				list.setModel(dlm);
				}
			
			}
		});
		panel_3.add(btnSort);
		
		
		
		tglbtnPoint.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if(e.getStateChange()==e.SELECTED)
				{
					tglbtnLine.setSelected(false);
					tglbtnCircle.setSelected(false);
					tglbtnRectangle.setSelected(false);
					tglbtnDonut.setSelected(false);
					tglbtnSelect.setSelected(false);
					tglbtnDelete.setSelected(false);
					
				
					
				}

				
			}
		});
		
		tglbtnLine.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if(e.getStateChange()==e.SELECTED)
				{
					tglbtnPoint.setSelected(false);
					tglbtnCircle.setSelected(false);
					tglbtnRectangle.setSelected(false);
					tglbtnDonut.setSelected(false);
					tglbtnSelect.setSelected(false);
					tglbtnDelete.setSelected(false);
					
				
					
				}
			
			}
		});
		
		tglbtnCircle.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if(e.getStateChange()==e.SELECTED)
				{
					tglbtnLine.setSelected(false);
					tglbtnPoint.setSelected(false);
					tglbtnRectangle.setSelected(false);
					tglbtnDonut.setSelected(false);
					tglbtnSelect.setSelected(false);
					tglbtnDelete.setSelected(false);
					
				
					
				}
			
			}
		});
		
		
		tglbtnRectangle.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if(e.getStateChange()==e.SELECTED )
				{
					tglbtnLine.setSelected(false);
					tglbtnCircle.setSelected(false);
					tglbtnPoint.setSelected(false);
					tglbtnDonut.setSelected(false);
					tglbtnSelect.setSelected(false);
					tglbtnDelete.setSelected(false);
					
				
					
				}

			}
		});
		
		
		tglbtnDonut.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if(e.getStateChange()==e.SELECTED )
				{
					tglbtnLine.setSelected(false);
					tglbtnCircle.setSelected(false);
					tglbtnPoint.setSelected(false);
					tglbtnRectangle.setSelected(false);
					tglbtnSelect.setSelected(false);
					tglbtnDelete.setSelected(false);
					

					
				}

			}
		});
		
		
		tglbtnSelect.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if(e.getStateChange()==e.SELECTED )
				{
					tglbtnLine.setSelected(false);
					tglbtnCircle.setSelected(false);
					tglbtnPoint.setSelected(false);
					tglbtnDonut.setSelected(false);
					tglbtnRectangle.setSelected(false);
					tglbtnDelete.setSelected(false);
					

				}

			}
		});
		
		
		tglbtnDelete.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if(e.getStateChange()==e.SELECTED )
				{
					tglbtnLine.setSelected(false);
					tglbtnCircle.setSelected(false);
					tglbtnPoint.setSelected(false);
					tglbtnDonut.setSelected(false);
					tglbtnSelect.setSelected(false);
					tglbtnRectangle.setSelected(false);

				}

			}
		});
		
		canvas.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				
				koordinata.setText(e.getX()+","+e.getY());
			}
		});
		
		
		canvas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(tglbtnPoint.isSelected())
				{
					Point p=new Point(e.getX(),e.getY());
					canvas.getShapes().add(p);
					
					repaint();
					
				}
				
				if(tglbtnLine.isSelected())
				{

					if(twoPoints==false){
		                nextPoint = new Point(e.getX(),e.getY());
		                twoPoints = true;
		            }
		            else{
		                
		                previousPoint = nextPoint;
		                nextPoint = new Point(e.getX(),e.getY());

					Line l=new Line(previousPoint,nextPoint);
					canvas.getShapes().add(l);
					repaint();
					previousPoint=new Point();
					twoPoints=false;
				}
				}

				if(tglbtnRectangle.isSelected())
				{
					Point upperLeft=new Point(e.getX(),e.getY());
					dlgrec = new DlgRectangle();
					dlgrec.setVisible(true);

					if(dlgrec.check==true)
					{
					 int width=Integer.parseInt(dlgrec.textFieldWidth.getText());
					 int height=Integer.parseInt(dlgrec.textFieldHeight.getText());
					 
					 Rectangle r=new Rectangle(upperLeft,width,height);
					 
					 
					canvas.getShapes().add(r);
					repaint();
					
					}
				}
				
				if(tglbtnCircle.isSelected())
				{
					Point center=new Point(e.getX(),e.getY());
					dlgcir = new DlgCircle();
					dlgcir.setVisible(true);

					if(dlgcir.check==true)
					{
					 int radius=Integer.parseInt(dlgcir.textFieldRadius.getText());
					 
					 Circle c=new Circle(center,radius);
					 
					 
					 canvas.getShapes().add(c);
					 repaint();
					 
					}
				}
				
				if(tglbtnDonut.isSelected())
				{
					Point center=new Point(e.getX(),e.getY());
					dlgdon=new DlgDonut();
					dlgdon.setVisible(true);

					if(dlgdon.check==true)
					{
					 int radius=Integer.parseInt(dlgdon.textFieldRadius.getText());
					 int innerRadius=Integer.parseInt(dlgdon.textFieldInnerRadius.getText());
					 
					 Donut d=new Donut(center,radius,innerRadius);
	
					 canvas.getShapes().add(d);
					 repaint();
					 
					}
				}
				
				if(tglbtnSelect.isSelected())
				{

					for(Shape s:canvas.getShapes())
					{
						if(s.contains(e.getX(),e.getY()))
						{

							if(s instanceof Point)
							{
								Point temp=(Point)s;
								Point novi=new Point();
								
								dlgp=new DlgPoint();
								
								dlgp.getTextFieldX().setText(Integer.toString(temp.getX()));
								dlgp.getTextFieldY().setText(Integer.toString(temp.getY()));
								
								dlgp.setVisible(true);
								if(dlgp.check) 
								{
									s.setSelected(true);
									novi.setC(dlgp.c);
								novi.moveTo(Integer.parseInt(dlgp.getTextFieldX().getText()), Integer.parseInt(dlgp.getTextFieldY().getText()));
	
								canvas.getShapes().set(canvas.getShapes().indexOf(s), novi);
								
								repaint();
								}
								
							}
							
							if(s instanceof Line)
							{
								Line temp=(Line)s;
								Line novi=new Line();
								
								dlgl=new DlgLine();
								
								
								dlgl.getTextFieldStartX().setText(Integer.toString(temp.getStartPoint().getX()));
								dlgl.getTextFieldStartY().setText(Integer.toString(temp.getStartPoint().getY()));
								dlgl.getTextFieldEndX().setText(Integer.toString(temp.getEndPoint().getX()));
								dlgl.getTextFieldEndY().setText(Integer.toString(temp.getEndPoint().getY()));
								dlgl.setVisible(true);
								
								if(dlgl.check)
								{
									
									s.setSelected(true);
									novi.setC(dlgl.c);
								novi.setStartPoint(new Point(Integer.parseInt(dlgl.getTextFieldStartX().getText()),Integer.parseInt(dlgl.getTextFieldStartY().getText())));
								novi.setEndPoint(new Point(Integer.parseInt(dlgl.getTextFieldEndX().getText()),Integer.parseInt(dlgl.getTextFieldEndY().getText())));		
								
								
								canvas.getShapes().set(canvas.getShapes().indexOf(s), novi);
								repaint();
								
								}	
								
							}
							
							if(s instanceof Circle)
							{
								Circle temp=(Circle)s;
								Circle novi=new Circle();
								
								dlgcirm=new DlgCircleM();
								
								
								dlgcirm.getTextFieldRadius().setText(Integer.toString(temp.getRadius()));
								dlgcirm.getTextFieldX().setText(Integer.toString(temp.getCenter().getX()));
								dlgcirm.getTextFieldY().setText(Integer.toString(temp.getCenter().getY()));
								
								dlgcirm.setVisible(true);
								
								if(dlgcirm.check)
								{
									s.setSelected(true);
									novi.setCenter(new Point(Integer.parseInt(dlgcirm.getTextFieldX().getText()),Integer.parseInt(dlgcirm.getTextFieldY().getText())));
									try {
										novi.setRadius(Integer.parseInt(dlgcirm.getTextFieldRadius().getText()));
									} catch (NumberFormatException e1) {
										
										e1.printStackTrace();
									} catch (Exception e1) {
										
										e1.printStackTrace();
									}
									novi.setC(dlgcirm.c);
									
									canvas.getShapes().set(canvas.getShapes().indexOf(s), novi);
									repaint();
									
								}
							}
								
								
								if(s instanceof Rectangle)
								{
									Rectangle temp=(Rectangle)s;
									Rectangle novi=new Rectangle();
									
									dlgrecm=new DlgRectangleM();

									dlgrecm.getTextFieldWidth().setText(Integer.toString(temp.getWidth()));
									dlgrecm.getTextFieldHeight().setText(Integer.toString(temp.getHeight()));
									dlgrecm.getTextFieldX().setText(Integer.toString(temp.getUpperLeft().getX()));
									dlgrecm.getTextFieldY().setText(Integer.toString(temp.getUpperLeft().getY()));
									dlgrecm.setVisible(true);
									
									if(dlgrecm.check)
									{
										s.setSelected(true);
										novi.setC(dlgrecm.c);
										novi.setWidth(Integer.parseInt(dlgrecm.getTextFieldWidth().getText()));
										novi.setHeight(Integer.parseInt(dlgrecm.getTextFieldHeight().getText()));
										novi.setUpperLeft(new Point(Integer.parseInt(dlgrecm.getTextFieldX().getText()),Integer.parseInt(dlgrecm.getTextFieldY().getText())));
										
										canvas.getShapes().set(canvas.getShapes().indexOf(s), novi);
										repaint();
									}
									
								}
									
							
								if(s instanceof Donut)
								{
									Donut temp=(Donut)s;
									Donut novi=new Donut();
									
									dlgdonm=new DlgDonutM();
									
									dlgdonm.getTextFieldOR().setText(Integer.toString(temp.getRadius()));
									dlgdonm.getTextFieldIR().setText(Integer.toString(temp.getInnerRadius()));
									dlgdonm.getTextFieldX().setText(Integer.toString(temp.getCenter().getX()));
									dlgdonm.getTextFieldY().setText(Integer.toString(temp.getCenter().getY()));
									
									dlgdonm.setVisible(true);
									
									if(dlgdonm.check)
									{
										s.setSelected(true);
										novi.setC(dlgdonm.c);
										novi.setCenter(new Point(Integer.parseInt(dlgdonm.getTextFieldX().getText()),Integer.parseInt(dlgdonm.getTextFieldY().getText())));
										try {
											novi.setRadius(Integer.parseInt(dlgdonm.getTextFieldOR().getText()));
										} catch (NumberFormatException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										} catch (Exception e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
										
										novi.setInnerRadius(Integer.parseInt(dlgdonm.getTextFieldIR().getText()));
										
										canvas.getShapes().set(canvas.getShapes().indexOf(s), novi);
									repaint();	
									}
									
									repaint();
								}
						}
							
							
					}

				}
					
					
					if(tglbtnDelete.isSelected())
					{
						
						for(int j=0; j< canvas.getShapes().size(); j++)
						{

							if(canvas.getShapes().get(j).contains(e.getX(),e.getY()))
							{
								
								int res = JOptionPane.showConfirmDialog(null, 
								         "Da li ste sigurni da zelite da obrisete?", 
								         "Brisanje", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
								if(res==JOptionPane.YES_OPTION)
								{
									canvas.getShapes().remove(canvas.getShapes().get(j));
	
								}
							}
						
							repaint();
						}
						
							
							
					
					}
				
				
			}
			
		});
		
	}

}
