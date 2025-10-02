import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.UUID;

public class BienImmobilier {
    public static final String TYPE_MAISON = "Maison";
    public static final String TYPE_APPARTEMENT = "Appartement";
    
    
    
    private String id;
    private String type;
    private String rue;
    private String ville;
    private String codePostal;
    public ArrayList<Piece> pieces = new ArrayList<Piece>();



    public BienImmobilier( String type, String rue, String ville, String codePostal) {
        this.id = UUID.randomUUID().toString().substring(0, 5);
        this.type = type;
        this.rue = rue;
        this.ville = ville;
        this.codePostal = codePostal;
    }

    public double surfaceHabitable() {
        double surfaceHabitable = 0;
        for (Piece piece : pieces) {
            if (piece.getTypePiece().isSurfaceHabitable()) {
                surfaceHabitable += piece.Surface();
            }
        }
        return surfaceHabitable;
    }

    public double surfaceNonHabitable() {
        double surfaceNonHabitable = 0;
        for (Piece piece : pieces) {
            if (!piece.getTypePiece().isSurfaceHabitable()) {
                surfaceNonHabitable += piece.Surface();
            }
        }
        return surfaceNonHabitable;
    }

    public void ajouterPiece(Piece piece) {
        pieces.add(piece);
    }


    public String getRue() {
        return rue;
    }
    public void setRue(String rue) {
        this.rue = rue;
    }
    public String getVille() {
        return ville;
    }
    public void setVille(String ville) {
        this.ville = ville;
    }
    public String getCodePostal() {
        return codePostal;
    }
    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public ArrayList<Piece> getPieces() {
        return pieces;
    }
    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }
    
    public String toStringPieces() {
        StringBuilder sb = new StringBuilder();
        for (Piece piece : pieces) {
            sb.append(piece.toString());
        }
        return sb.toString();
    }
    

    @Override
    public String toString() {
    DecimalFormat numberFormat = new DecimalFormat("#.00");
    return type + " " + id +
            "\nLocalisation : " + rue + " " + codePostal + " " + ville +
            "\n \n Description du bien : \n" +
            toStringPieces() +
            "\nPour une surface habitable de : " + numberFormat.format(surfaceHabitable())
            + " m2 et une surface non habitable de : " + numberFormat.format(surfaceNonHabitable()) + " m2.";
}

}
