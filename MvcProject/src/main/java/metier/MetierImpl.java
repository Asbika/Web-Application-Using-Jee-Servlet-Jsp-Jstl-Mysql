package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MetierImpl implements ImetierCatalogue{

	/**
	 * Method for Relational Object Mapping.
	 * We are going to do all of that by HIBERNATE FRAMEWORK!
	 */
	@Override
	public List<Produit> getProduitParMC(String mc) {
		List<Produit> prods = new ArrayList<Produit>();
		Connection conn = SingletonConnection.getConnection();
		try {
		PreparedStatement ps =conn.prepareStatement("SELECT *FROM PRODUITS WHERE NOM_PRODUIT LIKE ? "); 
		ps.setString(1,"%"+mc+"%");
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Produit pr = new Produit();
			pr.setIdProduit(rs.getLong("ID_PRODUIT"));
			pr.setNomProduit(rs.getString("NOM_PRODUIT"));
			pr.setPrix(rs.getDouble("PRIX"));
			prods.add(pr);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return prods;
	}

	@Override
	public void addProduit(Produit p) {
		// TODO Auto-generated method stub	
	}

}
