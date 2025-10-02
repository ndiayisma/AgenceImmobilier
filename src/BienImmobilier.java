import java.text.DecimalFormat;
import java.util.ArrayList;

abstract class BienImmobilier {
    public static final String TYPE_MAISON = "Maison";
    public static final String TYPE_APPARTEMENT = "Appartement";
    
    
    
    private String id;
    private String type;
    private String adresse;
    private String ville;
    private String codePostal;
    public ArrayList<Piece> pieces = new ArrayList<Piece>();



    public BienImmobilier(String adresse, String ville, String codePostal, ArrayList<Piece> pieces) {
        this.adresse = adresse;
        this.ville = ville;
        this.codePostal = codePostal;
        this.pieces = pieces;
    }

    public BienImmobilier(String adresse, String ville, String codePostal) {
        this.adresse = adresse;
        this.ville = ville;
        this.codePostal = codePostal;
    }

    public double surfaceHabitable() {
        double surfaceHabitable = 0;
        for (Piece piece : pieces) {
            if (piece.getTypePiece().surfaceHabitable) {
                surfaceHabitable += piece.Surface();
            }
        }
        return surfaceHabitable;
    }

    public double surfaceNonHabitable() {
        double surfaceNonHabitable = 0;
        for (Piece piece : pieces) {
            if (!piece.getTypePiece().surfaceHabitable) {
                surfaceNonHabitable += piece.Surface();
            }
        }
        return surfaceNonHabitable;
    }

    public void ajouterPiece(Piece piece) {
        pieces.add(piece);
    }


    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
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
    public Vendeur getVendeur() {
        return vendeur;
    }
    public void setVendeur(Vendeur vendeur) {
        this.vendeur = vendeur;
    }
    public ArrayList<Piece> getPieces() {
        return pieces;
    }
    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }
    

    @Override
    public String toString() {
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        return "\nLocalisation : " + adresse + ", " + codePostal + " " + ville +  "\n" +
                "\n Description du bien : \n" + pieces.toString() +
                "\nPour une surface habitable de : " + 
                numberFormat.format(surfaceHabitable()) + 
                " m² et une surface non habitable de : " +
                numberFormat.format(surfaceNonHabitable()) + " m²";
    }
}
