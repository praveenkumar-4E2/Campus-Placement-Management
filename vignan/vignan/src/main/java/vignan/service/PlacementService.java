package vignan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vignan.model.Placement;
import vignan.repository.PlacementRepository;

@Service
public class PlacementService {
	@Autowired
	PlacementRepository placementRepository;
	
	public Placement addPlacement(Placement placement) {
		return placementRepository.save(placement);
	}
	public List<Placement> getAll(){
		return placementRepository.findAll();
	}
	public String  deletePlacement(int id) {
		placementRepository.deleteById(id);
		return "deleted";
	}
}
