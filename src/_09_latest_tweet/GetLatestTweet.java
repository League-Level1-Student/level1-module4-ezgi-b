package _09_latest_tweet;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class GetLatestTweet implements ActionListener {
	JLabel label;
	JTextField search;
	JFrame frame = new JFrame();
	JButton enter;
	void CreateUI(){
		Dimension d = new Dimension(120,25);
		frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(3);
		JPanel panel = new JPanel();
		search = new JTextField();
		search.setPreferredSize(d);
		enter = new JButton("Search the Twitterverse");
		enter.addActionListener(this);
		label = new JLabel();
		
		frame.add(panel);
		panel.add(search);
		panel.add(enter);
		panel.add(label);
		frame.pack();
	}
	public static void main(String[] args) {
		GetLatestTweet t = new GetLatestTweet();
		t.CreateUI();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	System.out.println("Tweet Tweet");
	label.setText(getLatestTweet(search.getText()));
	frame.pack();
		
	}
	private String getLatestTweet(String searchingFor) {

	      Twitter twitter = new TwitterFactory().getInstance();

	      AccessToken accessToken = new AccessToken(
	            "2453751158-IVD2VGZsvwZiRKxNe3Gs2lMjg30nvSkV1xSuPFf",
	            "vBa5PjKfuMTK1LLBG51nCUI9r5d6Ph5cAHrS73spg6Nvu");

	      twitter.setOAuthConsumer("YqeZdD2hYxOKv4QOkmp0i2djN",
	            "6XUB1r8KXBvd8Pk9HHW3NgphMxHvHWBLAr5TihnckMU0ttyGST");

	      twitter.setOAuthAccessToken(accessToken);

	      Query query = new Query(searchingFor);
	      try {
	            QueryResult result = twitter.search(query);
	            return result.getTweets().get(0).getText();
	      } catch (Exception e) {
	            System.err.print(e.getMessage());
	            return "What the heck is that?";
	      }
	}

}
