package question3;
import java.text.Normalizer;
import java.util.regex.*;
/**
 * NFP121 TpIntroduction, usage de BlueJ et du "Submitter".
 * 
 * @version septembre 2009
 * @author à compléter
 * @see java.lang.String, java.lang.Math
 */
public class AuditeurCNAM {
    /** l'attribut nom de chaque auditeur. */
    private String nom;
    /** l'attribut prenom de chaque auditeur. */
    private String prenom;
    /** l'attribut matricule de chaque auditeur. */
    private String matricule;

    /**
     * "Création", le constructeur d'un auditeur avec son nom, son prénom et son
     * matricule.
     * 
     * @param nom
     *            le nom de l'auditeur
     * @param prenom
     *            son prénom
     * @param matricule
     *            sur la carte d'inscription, près de la photo
     */
    public AuditeurCNAM(String nom, String prenom, String matricule) {
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
    }

    /**
     * le login au Cnam : 6 premières lettres du nom suivies de la première
     * lettre du prénom séparées de '_' . le login retourné est en minuscules,
     * le trait d'union, ou spéciaux <i>(pour unix)</i> sont remplacés par des
     * '_' pas de caractères accentués pour le login voir les classes
     * prédéfines, java.lang.String : les méthodes replaceAll, toLowerCase et
     * substring java.lang.Math : la méthode min<br>
     * <b>BlueJ : Menu Aide</b>
     * 
     * @return le login du Cnam simplifié, sans les adaptations dues aux
     *         homonymes...
     */
    public String login() 
    {
        if(nom==null||prenom==null||nom.isEmpty()||prenom.isEmpty())
            return null;
        
        //initialisation pour eviter dexception
        String subnom="",prenomChar="";
        char symbole='_';
        
        //prendre le string de 0 a 5 (6 lettres)
        //on a pris les 6 premier charactere (avec ou sans symbole)
        subnom=nom.substring(0,6);
            
        //elever tout accent (é => e etc..) 
        subnom= Normalizer.normalize(subnom, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        
        //remplacer tout symbole special (non alphanumerqiue) par un "_"
        subnom=subnom.replaceAll("[^A-Za-z0-9]","_");        

        //elever tout accent (é => e etc..) puis
        //prendre le premier charactere du prenom 
        //PS : on prend le cas qun prenom peu etre : __fontaine
        //dans ce cas charAt(0) ne fonctionne pas
        prenomChar= Normalizer.normalize(prenom, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        Pattern firstLetterPattern = Pattern.compile("\\b[a-zA-Z]"); 
        Matcher firstLetterMatcher = firstLetterPattern.matcher(prenomChar); 
        
        if (firstLetterMatcher.find())
            prenomChar=firstLetterMatcher.group();
        
        return subnom.toLowerCase()
        +symbole
        +prenomChar.toLowerCase();
    }

    /**
     * Lecture du nom de l'auditeur.
     * 
     * @return son nom
     */
    public String nom() {
        return nom;
    }

    /**
     * Lecture du prénom de l'auditeur.
     * 
     * @return son prénom
     */
    public String prenom() {
        return prenom;
    }

    /**
     * Lecture du matricule de l'auditeur.
     * 
     * @return son matricule
     */
    public String matricule() {
        return matricule;
    }

    /**
     * méthode toString ( méthode redéfinie de la classe Object).
     * 
     * @return la concaténation du nom, du prénom et du login, selon cette
     *         syntaxe
     *         <code>nom() + " " + prenom() +  " login : " + login()</code>
     */
    @Override
    public String toString() {
        return nom() + " " + prenom() + " login : " + login();
    }

}
