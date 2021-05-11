package fr.unilim.iut.spaceinvaders;

import fr.unilim.iut.spaceinvaders.utils.HorsEspaceJeuException;

public class SpaceInvaders {
	    
	    private static final char MARQUE_FIN_LIGNE = '\n';
		private static final char MARQUE_VIDE = '.';
		private static final char MARQUE_VAISSEAU = 'V';
		int longueur;
	    int hauteur;
	    Vaisseau vaisseau;
	    char marque;
	   
	    

	    public SpaceInvaders(int longueur, int hauteur) {
		   this.longueur = longueur;
		   this.hauteur = hauteur;
		  
	   }
	    
	    
		private boolean aUnVaisseau() {
			return vaisseau != null;
		}
		

		public void positionnerUnNouveauVaisseau(int x, int y) {
				
			if (  !estDansEspaceJeu(x, y) )
				throw new HorsEspaceJeuException("La position du vaisseau est en dehors de l'espace jeu");
			
			vaisseau = new Vaisseau(x, y); 

		}


		private boolean estDansEspaceJeu(int x, int y) {
			return ((x >= 0) && (x < longueur)) && ((y >= 0) && (y < hauteur));
		}

		
		String recupererEspaceJeuDansChaineASCII() {
			StringBuilder espaceDeJeu = new StringBuilder();
			for (int y = 0; y < hauteur; y++) {
				for (int x = 0; x < longueur; x++) {
						espaceDeJeu.append(recupereMarqueDeLaPosition(x, y));
				}
				espaceDeJeu.append(MARQUE_FIN_LIGNE); 
			} 
			return espaceDeJeu.toString();
		}


		private char recupereMarqueDeLaPosition(int x, int y) {
			char marque;
			 if (this.aUnVaisseauQuiOccupeLaPosition(x, y))
				marque=MARQUE_VAISSEAU;
			 else
				marque=MARQUE_VIDE;
			return marque;
		}


		private boolean aUnVaisseauQuiOccupeLaPosition(int x, int y) {
			return this.aUnVaisseau() && vaisseau.occupeLaPosition(x, y);
		}

		
		
		
		
		
		 @Override
			public String toString() {
				return recupererEspaceJeuDansChaineASCII();
			}


		 public void deplacerVaisseauVersLaDroite() {
		        if (vaisseau.abscisse()< (longueur-1)) vaisseau.seDeplacerVersLaDroite();
			}
		 
		
 }
