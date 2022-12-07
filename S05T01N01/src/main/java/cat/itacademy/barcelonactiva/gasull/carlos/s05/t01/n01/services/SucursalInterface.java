package cat.itacademy.barcelonactiva.gasull.carlos.s05.t01.n01.services;

import cat.itacademy.barcelonactiva.gasull.carlos.s05.t01.n01.model.Sucursal;

import java.util.List;

public interface SucursalInterface {

    List<Sucursal> listAllSucursal();

    Sucursal saveSucursal(Sucursal sucursal);

    Sucursal getSucursalById(Long id);

    Sucursal updateSucursal(Sucursal sucursal);

    void deleteSucursal(Long id);
}

