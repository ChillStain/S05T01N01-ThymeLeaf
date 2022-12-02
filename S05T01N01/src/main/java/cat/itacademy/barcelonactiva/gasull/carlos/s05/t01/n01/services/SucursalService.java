package cat.itacademy.barcelonactiva.gasull.carlos.s05.t01.n01.services;

import cat.itacademy.barcelonactiva.gasull.carlos.s05.t01.n01.DTO.SucursalDTO;
import cat.itacademy.barcelonactiva.gasull.carlos.s05.t01.n01.model.Sucursal;
import cat.itacademy.barcelonactiva.gasull.carlos.s05.t01.n01.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class SucursalService implements SucursalInterface {

    @Autowired
    private SucursalRepository sucursalRepository;


    public Sucursal agregarSucursal(SucursalDTO sucursalDto){
        Sucursal sucursal = new Sucursal
                (sucursalDto.getNombreSucursal(),sucursalDto.getPaisSucursal(),sucursalDto.verificacionUE(sucursalDto.getPaisSucursal())) ;
        sucursalRepository.save(sucursal);
        return sucursal;
    }

    public void actualizarSucursal(Sucursal sucursal){
        sucursalRepository.save(sucursal);
    }

    public void eliminarSucursal (Long id){
        sucursalRepository.deleteById(id);
    }

    public Sucursal getSucursal (Long id) throws Exception {
        Optional<Sucursal> optionalSucursal = sucursalRepository.findById(id);
        return optionalSucursal.orElseThrow(() -> new Exception("No se encuentra la sucursal con id: " + id));
    }

    public List<Sucursal> getAllSucursal (){
        return sucursalRepository.findAll();
    }

    public boolean findById(Long id){
        return sucursalRepository.existsById(id);
    }


    @Override
    public List<Sucursal> listAllSucursal() {
        return null;
    }
}
