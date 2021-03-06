package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Filters.Filter;
import Main.Main;
import Objects.Point3D;
import Tools.CreateCsv;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LocationFilter extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LocationFilter frame = new LocationFilter();
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
	public LocationFilter() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 355, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAlgorithm = new JLabel("Distance Filter");
		lblAlgorithm.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAlgorithm.setBounds(102, 5, 153, 31);
		contentPane.add(lblAlgorithm);

		JButton btnOk = new JButton("Ok");
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!textField.getText().isEmpty()&&!textField.getText().isEmpty()&&!textField_3.getText().isEmpty())
				{
					double lat=Double.parseDouble(textField.getText());
					double lon=Double.parseDouble(textField_1.getText());
					double alt=Double.parseDouble(textField_2.getText());
					double distance=Double.parseDouble(textField_3.getText());

					Point3D place = new Point3D(lat, lon, 0);
					Main.filter = new Filter("Distance", place, distance);
					String FileName = "DistanceCSV";
					Main.WifilistTemp=Main.Wifilist;
					Main.setWifilist(CreateCsv.ArrayByFilter(Main.getWifilist(), Main.filter,FileName, Main.getFolder()));
					dispose();
				}
			}
		});
		btnOk.setBounds(107, 250, 115, 29);
		contentPane.add(btnOk);

		JLabel lblEnterMac = new JLabel("Enter your loaction:");
		lblEnterMac.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnterMac.setBounds(15, 52, 193, 20);
		contentPane.add(lblEnterMac);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(144, 92, 158, 26);
		contentPane.add(textField);

		JLabel lblMaxTime = new JLabel("Alt:");
		lblMaxTime.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMaxTime.setBounds(15, 166, 95, 20);
		contentPane.add(lblMaxTime);

		JLabel lblLat = new JLabel("Lat:");
		lblLat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLat.setBounds(15, 94, 95, 20);
		contentPane.add(lblLat);

		JLabel lblLon = new JLabel("Lon:");
		lblLon.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLon.setBounds(15, 130, 95, 20);
		contentPane.add(lblLon);

		JLabel lblDistancekm = new JLabel("Distance (km):");
		lblDistancekm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDistancekm.setBounds(15, 209, 145, 20);
		contentPane.add(lblDistancekm);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(144, 128, 158, 26);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(144, 164, 158, 26);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(144, 206, 158, 26);
		contentPane.add(textField_3);
	}
}
