package controller;

public class Main {
	MainFrame frame;
    
	
	public Main() {
		frame = new MainFrame();
		Time time = new Time();
		time.start();
		new Thread(frame).start();
	}
    
	public static void main(String[] args) {
		new Main();
	}
	
	class Time extends Thread {
		public void run() {
			while (true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}	
	            if(frame.isPause()){
	                    if(frame.isResume()){
	                            frame.time--;
	                    }
	            }else{
	                    frame.time--;
	            }
				if (frame.time == 0) {
					frame.showDialogNewGame(
						"Tôi không có buồn đâu, tôi chỉ thất vọng về bạn mà thôi!\nLỡ rồi, làm lại không?", "Lose",1);
				}
			}
		}
	}
}
