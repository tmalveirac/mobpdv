package br.android.mobpdv.model;


import android.os.Parcel;
import android.os.Parcelable;

public class Produto implements Parcelable{
	
	private int codigo;
	private String descricao;
	private double valor;
	//private CategoriaProduto categoriaProduto;
	
	public Produto(int codigo, String descricao, double valor, CategoriaProduto categoriaProduto) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.valor = valor;
		//this.categoriaProduto = categoriaProduto;
		
	}

	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}

	/*public CategoriaProduto getCategoriaProduto() {
		return categoriaProduto;
	}

	public void setCategoriaProduto(CategoriaProduto categoriaProduto) {
		this.categoriaProduto = categoriaProduto;
	}
	*/

	
	
	  // Parcelling part
    public Produto(Parcel in){
    	readFromParcel(in);
    }

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    	dest.writeInt(codigo);
    	dest.writeString(descricao);
    	dest.writeDouble(valor);
    }
    public static final Parcelable.Creator<Produto> CREATOR = new Parcelable.Creator<Produto>() {
        public Produto createFromParcel(Parcel in) {
            return new Produto(in); 
        }

        public Produto[] newArray(int size) {
            return new Produto[size];
        }
    };
	
    private void readFromParcel(Parcel in) {
    	 
		// We just need to read back each
		// field in the order that it was
		// written to the parcel
		codigo = in.readInt();
		descricao = in.readString();
		valor = in.readDouble();
	}
	
	
}
