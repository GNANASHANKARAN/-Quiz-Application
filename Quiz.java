
// ---------------------------- Quiz ----------------------------
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Quiz implements ActionListener{
	
	String[] questions = 	{
								"Which company created Java?",
								"Which year was Java created?",
								"What was Java originally called?",
								"Who is credited with creating Java?",
								"Which is correct data type for 5.5f?",
								"Which is Non perimitive data data types?",
								"What is the size of short variable?",
								"What is the default value of float variable?"
							};
	String[][] options = 	{
								{"Sun Microsystems","Starbucks","Microsoft","Alphabet"},
								{"1989","1995","1972","1492"},
								{"Apple","Latte","Oak","Koffing"},
								{"Steve Jobs","Bill Gates","James Gosling","Mark Zuckerburg"},
								{"int","float","string","char"},
								{"int","char","string","long"},
								{"2byte","4byte,","1byte","8byte"},
								{"0.0d","0.0f","0.0","Not defind"}
							};
	char[] answers = 		{
								'A',
								'B',
								'C',
								'C',
								'B',
								'C',
								'A',
								'B'
							};
	char guess;
	char answer;
	int index;
	int correct_guesses =0;
	int total_questions = questions.length;
	int result;
	int seconds=10;
	
	JFrame frame = new JFrame();
	JTextField textfield = new JTextField();
	JTextArea textarea = new JTextArea();
	JButton buttonA = new JButton();
	JButton buttonB = new JButton();
	JButton buttonC = new JButton();
	JButton buttonD = new JButton();
	JButton buttonE = new JButton();
	JButton buttonF = new JButton();
	JButton buttonG = new JButton();
	JButton buttonH = new JButton();
	JLabel answer_labelA = new JLabel();
	JLabel answer_labelB = new JLabel();
	JLabel answer_labelC = new JLabel();
	JLabel answer_labelD = new JLabel();
	JLabel answer_labelE = new JLabel();
	JLabel answer_labelF = new JLabel();
	JLabel answer_labelG = new JLabel();
	JLabel answer_labelH = new JLabel();
	JLabel time_label = new JLabel();
	JLabel seconds_left = new JLabel();
	JTextField number_right = new JTextField();
	JTextField percentage = new JTextField();
	
	Timer timer = new Timer(1000, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			seconds--;
			seconds_left.setText(String.valueOf(seconds));
			if(seconds<=0) {
				displayAnswer();
			}
			}
		});
	
	public Quiz() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650,650);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(null);
		frame.setResizable(false);
		
		textfield.setBounds(0,0,650,50);
		textfield.setBackground(new Color(25,25,25));
		textfield.setForeground(new Color(25,255,0));
		textfield.setFont(new Font("Ink Free",Font.BOLD,30));
		textfield.setBorder(BorderFactory.createBevelBorder(1));
		textfield.setHorizontalAlignment(JTextField.CENTER);
		textfield.setEditable(false);
		
		textarea.setBounds(0,50,650,50);
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		textarea.setBackground(new Color(25,25,25));
		textarea.setForeground(new Color(25,255,0));
		textarea.setFont(new Font("MV Boli",Font.BOLD,25));
		textarea.setBorder(BorderFactory.createBevelBorder(1));
		textarea.setEditable(false);
		
		buttonA.setBounds(0,100,100,100);
		buttonA.setFont(new Font("MV Boli",Font.BOLD,35));
		buttonA.setFocusable(false);
		buttonA.addActionListener(this);
		buttonA.setText("A");
		
		buttonB.setBounds(0,200,100,100);
		buttonB.setFont(new Font("MV Boli",Font.BOLD,35));
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		buttonB.setText("B");
		
		buttonC.setBounds(0,300,100,100);
		buttonC.setFont(new Font("MV Boli",Font.BOLD,35));
		buttonC.setFocusable(false);
		buttonC.addActionListener(this);
		buttonC.setText("C");
		
		buttonD.setBounds(0,400,100,100);
		buttonD.setFont(new Font("MV Boli",Font.BOLD,35));
		buttonD.setFocusable(false);
		buttonD.addActionListener(this);
		buttonD.setText("D");

		buttonE.setBounds(0,500,100,100);
		buttonE.setFont(new Font("MV Boli",Font.BOLD,35));
		buttonE.setFocusable(false);
		buttonE.addActionListener(this);
		buttonE.setText("E");

		buttonF.setBounds(0,500,100,100);
		buttonF.setFont(new Font("MV Boli",Font.BOLD,35));
		buttonF.setFocusable(false);
		buttonF.addActionListener(this);
		buttonF.setText("F");

		buttonG.setBounds(0,500,100,100);
		buttonG.setFont(new Font("MV Boli",Font.BOLD,35));
		buttonG.setFocusable(false);
		buttonG.addActionListener(this);
		buttonG.setText("G");

		buttonH.setBounds(0,100,100,100);
		buttonH.setFont(new Font("MV Boli",Font.BOLD,35));
		buttonH.setFocusable(false);
		buttonH.addActionListener(this);
		buttonH.setText("A");
		
		answer_labelA.setBounds(125,100,500,100);
		answer_labelA.setBackground(new Color(50,50,50));
		answer_labelA.setForeground(new Color(25,255,0));
		answer_labelA.setFont(new Font("MV Boli",Font.PLAIN,35));
		
		answer_labelB.setBounds(125,200,500,100);
		answer_labelB.setBackground(new Color(50,50,50));
		answer_labelB.setForeground(new Color(25,255,0));
		answer_labelB.setFont(new Font("MV Boli",Font.PLAIN,35));
		
		answer_labelC.setBounds(125,300,500,100);
		answer_labelC.setBackground(new Color(50,50,50));
		answer_labelC.setForeground(new Color(25,255,0));
		answer_labelC.setFont(new Font("MV Boli",Font.PLAIN,35));
		
		answer_labelD.setBounds(125,400,500,100);
		answer_labelD.setBackground(new Color(50,50,50));
		answer_labelD.setForeground(new Color(25,255,0));
		answer_labelD.setFont(new Font("MV Boli",Font.PLAIN,35));

		answer_labelE.setBounds(125,500,500,100);
		answer_labelE.setBackground(new Color(50,50,50));
		answer_labelE.setForeground(new Color(25,255,0));
		answer_labelE.setFont(new Font("MV Boli",Font.PLAIN,35));

		answer_labelF.setBounds(125,500,500,100);
		answer_labelF.setBackground(new Color(50,50,50));
		answer_labelF.setForeground(new Color(25,255,0));
		answer_labelF.setFont(new Font("MV Boli",Font.PLAIN,35));

		answer_labelG.setBounds(125,500,500,100);
		answer_labelG.setBackground(new Color(50,50,50));
		answer_labelG.setForeground(new Color(25,255,0));
		answer_labelG.setFont(new Font("MV Boli",Font.PLAIN,35));

		answer_labelH.setBounds(125,100,500,100);
		answer_labelH.setBackground(new Color(50,50,50));
		answer_labelH.setForeground(new Color(25,255,0));
		answer_labelH.setFont(new Font("MV Boli",Font.PLAIN,35));
		
		seconds_left.setBounds(535,510,100,100);
		seconds_left.setBackground(new Color(25,25,25));
		seconds_left.setForeground(new Color(255,0,0));
		seconds_left.setFont(new Font("Ink Free",Font.BOLD,60));
		seconds_left.setBorder(BorderFactory.createBevelBorder(1));
		seconds_left.setOpaque(true);
		seconds_left.setHorizontalAlignment(JTextField.CENTER);
		seconds_left.setText(String.valueOf(seconds));
		
		time_label.setBounds(535,475,100,25);
		time_label.setBackground(new Color(50,50,50));
		time_label.setForeground(new Color(255,0,0));
		time_label.setFont(new Font("MV Boli",Font.PLAIN,16));
		time_label.setHorizontalAlignment(JTextField.CENTER);
		time_label.setText("timer >:H");
		
		number_right.setBounds(225,225,200,100);
		number_right.setBackground(new Color(25,25,25));
		number_right.setForeground(new Color(25,255,0));
		number_right.setFont(new Font("Ink Free",Font.BOLD,50));
		number_right.setBorder(BorderFactory.createBevelBorder(1));
		number_right.setHorizontalAlignment(JTextField.CENTER);
		number_right.setEditable(false);
		
		percentage.setBounds(225,325,200,100);
		percentage.setBackground(new Color(25,25,25));
		percentage.setForeground(new Color(25,255,0));
		percentage.setFont(new Font("Ink Free",Font.BOLD,50));
		percentage.setBorder(BorderFactory.createBevelBorder(1));
		percentage.setHorizontalAlignment(JTextField.CENTER);
		percentage.setEditable(false);
		
		frame.add(time_label);
		frame.add(seconds_left);
		frame.add(answer_labelA);
		frame.add(answer_labelB);
		frame.add(answer_labelC);
		frame.add(answer_labelD);
		frame.add(answer_labelE);
		frame.add(buttonA);
		frame.add(buttonB);
		frame.add(buttonC);
		frame.add(buttonD);
		
		frame.add(textarea);
		frame.add(textfield);
		frame.setVisible(true);
		
		nextQuestion();
	}
	public void nextQuestion() {
		
		if(index>=total_questions) {
			results();
		}
		else {
			textfield.setText("Question "+(index+1));
			textarea.setText(questions[index]);
			answer_labelA.setText(options[index][0]);
			answer_labelB.setText(options[index][1]);
			answer_labelC.setText(options[index][2]);
			answer_labelD.setText(options[index][3]);
			answer_labelE.setText(options[index][4]);
			answer_labelF.setText(options[index][5]);
			answer_labelG.setText(options[index][5]);
			answer_labelH.setText(options[index][5]);
			timer.start();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
			buttonA.setEnabled(false);
			buttonB.setEnabled(false);
			buttonC.setEnabled(false);
			buttonD.setEnabled(false);
			buttonE.setEnabled(false);
			buttonF.setEnabled(false);
			buttonG.setEnabled(false);
			buttonH.setEnabled(false);
			
			
			if(e.getSource()==buttonA) {
				answer= 'A';
				if(answer == answers[index]) {
					correct_guesses++;
				}
			}
			if(e.getSource()==buttonB) {
				answer= 'B';
				if(answer == answers[index]) {
					correct_guesses++;
				}
			}
			if(e.getSource()==buttonC) {
				answer= 'C';
				if(answer == answers[index]) {
					correct_guesses++;
				}
			}
			if(e.getSource()==buttonD) {
				answer= 'D';
				if(answer == answers[index]) {
					correct_guesses++;
				}
			}
			if(e.getSource()==buttonE) {
				answer= 'E';
				if(answer == answers[index]) {
					correct_guesses++;
				}
			}
			if(e.getSource()==buttonF) {
				answer= 'F';
				if(answer == answers[index]) {
					correct_guesses++;
				}
			}
			if(e.getSource()==buttonG) {
				answer= 'G';
				if(answer == answers[index]) {
					correct_guesses++;
				}
			}
			if(e.getSource()==buttonH) {
				answer= 'H';
				if(answer == answers[index]) {
					correct_guesses++;
				}
			}
			displayAnswer();
	}
	public void displayAnswer() {
		
		timer.stop();
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		buttonE.setEnabled(false);
		buttonF.setEnabled(false);
		buttonG.setEnabled(false);
		buttonH.setEnabled(false);
		
		if(answers[index] != 'A')
			answer_labelA.setForeground(new Color(255,0,0));
		if(answers[index] != 'B')
			answer_labelB.setForeground(new Color(255,0,0));
		if(answers[index] != 'C')
			answer_labelC.setForeground(new Color(255,0,0));
		if(answers[index] != 'D')
			answer_labelD.setForeground(new Color(255,0,0));
		if(answers[index] != 'E')
			answer_labelD.setForeground(new Color(255,0,0));
		if(answers[index] != 'F')
			answer_labelD.setForeground(new Color(255,0,0));
		if(answers[index] != 'G')
			answer_labelD.setForeground(new Color(255,0,0));
		if(answers[index] != 'H')
			answer_labelD.setForeground(new Color(255,0,0));
		
		
		Timer pause = new Timer(2000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				answer_labelA.setForeground(new Color(25,255,0));
				answer_labelB.setForeground(new Color(25,255,0));
				answer_labelC.setForeground(new Color(25,255,0));
				answer_labelD.setForeground(new Color(25,255,0));
				answer_labelE.setForeground(new Color(25,255,0));
				answer_labelF.setForeground(new Color(25,255,0));
				answer_labelG.setForeground(new Color(25,255,0));
				answer_labelH.setForeground(new Color(25,255,0));
				
				
				answer = ' ';
				seconds=10;
				seconds_left.setText(String.valueOf(seconds));
				buttonA.setEnabled(true);
				buttonB.setEnabled(true);
				buttonC.setEnabled(true);
				buttonD.setEnabled(true);
				buttonE.setEnabled(true);
				buttonF.setEnabled(true);
				buttonG.setEnabled(true);
				buttonH.setEnabled(true);
				index++;
				nextQuestion();
			}
		});
		pause.setRepeats(false);
		pause.start();
	}
	public void results(){
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		buttonE.setEnabled(false);
		buttonF.setEnabled(false);
		buttonG.setEnabled(false);
		buttonH.setEnabled(false);
		result = (int)((correct_guesses/(double)total_questions)*100);
		
		textfield.setText("RESULTS!");
		textarea.setText("");
		answer_labelA.setText("");
		answer_labelB.setText("");
		answer_labelC.setText("");
		answer_labelD.setText("");
		answer_labelE.setText("");
		answer_labelF.setText("");
		answer_labelG.setText("");
		answer_labelH.setText("");
		
		number_right.setText("("+correct_guesses+"/"+total_questions+")");
		percentage.setText(result+"%");
		
		frame.add(number_right);
		frame.add(percentage);
		
	}
}