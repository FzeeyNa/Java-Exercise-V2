package blocking2;
public class MainArray2{
	public static void main(String[] args)
	{ Array2 ob = new Array2();
	String [][] Mhs = {
			{"NIM","NAMA"},
			{"17650123","David"},
			{"17650124","Ahmad"},
			{"17650125","Ratih"},
			{"17650126","Dina"}
	};
	ob.tampil("Data Mahasiswa : ");
	ob.setMahasiswa(Mhs);
	ob.tampil(ob.getMahasiswa());
	ob.tampil("===================");
	int[][] data = {
			{1,2},
			{3,4},
			{5,6}
	};
	int pengali = 2;
	ob.tampil("Data Matrik : ");
	ob.setData(data);
	ob.tampil(ob.getData());
	ob.tampil("Data Matrik X "+pengali+" : ");
	ob.setPerkalianSkalar(data, pengali);
	ob.tampil(ob.getPerkalianSkalar());
	
	ob.hapus();
	Mhs = null;
	data = null;
	ob = null;
	}
}