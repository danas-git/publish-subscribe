

public class blogMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		blogView bv=new blogView();
		blogModel bm=new blogModel();
		
		blogController the=new blogController(bv, bm);
		bv.setVisible(true);
	}

}
