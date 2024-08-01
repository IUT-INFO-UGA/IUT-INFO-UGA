package TP6;

import static org.junit.jupiter.api.Assertions.*;

class ArticleTest {

	@org.junit.jupiter.api.Test
	void getIntitule() {
		Article article1 = new Article("minuscule", 2.0, 10);
		assertEquals(article1.getIntitule(), "Minuscule", "Un intitulé	doit avoir la première lettre en Majuscule et le reste en minuscule");
		Article article2 = new Article("MAJUSCULE", 2.0, 10);
		assertEquals(article2.getIntitule(), "Majuscule", "Un intitulé doit avoir la première lettre en Majuscule et le reste en minuscule");
	}

	@org.junit.jupiter.api.Test
	void getPrix() {
		Article article1 = new Article("minuscule", 2.0, 300);
		assertEquals(article1.getPrix(), 2.0, "le prix doit etre le bon");
		assertEquals(article1.getPrix(200), 40, "le prix doit etre le bon");
	}

	@org.junit.jupiter.api.Test
	void getStock() {
		Article article1 = new Article("minuscule", 2.0, 300);
		assertEquals(article1.getStock(), 300, "le prix doit etre le bon");
	}

	@org.junit.jupiter.api.Test
	void setIntitule() throws IntituleException{
		assertThrows(IntituleException.class, () -> {
			new Article(null, 2.0, 10);
		}, "Un intitulé ne peut pas être null.");
//
		assertThrows(IntituleException.class, () -> {
			new Article("", 2.0, 10);
		}, "Un intitulé ne peut pas être vide.");
	}

	@org.junit.jupiter.api.Test
	void setPrix() {
		final Article art = new Article("minuscule", 2.0, 10);
		assertThrows(PrixException.class, ()-> {art.setPrix(-1);}, "pas de prix <=0");
		art.setPrix(200);
		assertEquals(art.getPrix(), 200, "le prix doit etre le bon");
	}

	@org.junit.jupiter.api.Test
	void setStock() {
		Article article1 = new Article("minuscule", 2.0, 300);
		article1.setStock(10);
		assertEquals(article1.getStock(), 10, "le stock doit etre le bon");
		assertThrows(StockException.class, ()->{article1.setStock(-10);}, "pas d'erreur avec les stock negatif");
	}

	@org.junit.jupiter.api.Test
	void existQuantite() {
		Article article1 = new Article("minuscule", 2.0, 300);
		assertTrue(article1.existQuantite(200), "le stock doit etre le bon");
		assertFalse(article1.existQuantite(400), "le stock doit etre le bon");
	}

	@org.junit.jupiter.api.Test
	void removeQuantite() {
		Article article1 = new Article("minuscule", 2.0, 300);
		article1.setStock(10);
		assertEquals(article1.getStock(), 10, "le stock doit etre le bon");
		assertThrows(StockException.class, ()->{article1.setStock(-10);}, "pas d'erreur avec les stock negatif");
	}
}