import java.text.DecimalFormat;

abstract class Piece {
    private TypePiece typePiece;
    private String niveau;

    public TypePiece getTypePiece() {
        return typePiece;
    }

    public void setTypePiece(TypePiece typePiece) {
        this.typePiece = typePiece;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    abstract double Surface();

    public Piece(TypePiece typePiece, String niveau) {
        this.typePiece = typePiece;
        this.niveau = niveau;
    }

    @Override
    public String toString() {
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        return typePiece + " surface : " + numberFormat.format(Surface()) + " m2 \n";
    }


}