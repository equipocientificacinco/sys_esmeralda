package edu.cientifica.minimarket.servicesimpl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cientifica.minimarket.mappers.ProductoMapper;
import edu.cientifica.minimarket.model.Producto;
import edu.cientifica.minimarket.model.ProductoProveedor;
import edu.cientifica.minimarket.services.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{
	protected final Log LOG = LogFactory.getLog(this.getClass());
	
	@Autowired
	ProductoMapper productoMapper;

	@Override
	public int registrarProducto(Producto producto) {
		int a = productoMapper.addProducto(producto);
		int b = productoMapper.addTabProductoProveedor(producto);
		int result=a+b;
		LOG.info("Numero de registros afectados : "+result);
		return result;
	}

	@Override
	public List<Producto> listarProducto() {
		return productoMapper.findAllProducts();
	}

	@Override
	public int asignarId() {
		return productoMapper.findId();
	}

	@Override
	public Producto buscarProductoId(int idProducto) {
		
		return productoMapper.findProductId(idProducto);
	}

	@Override
	public Producto buscarCodBarras(String codBarras) {
		return productoMapper.findProductCodBarras(codBarras);
	}

	@Override
	public int actualizarProducto(Producto producto) {
		int result;
		result = productoMapper.updateProducto(producto);
		LOG.info("Numero de registros afectados : " + result);
		return result;
	}

	@Override
	public ProductoProveedor buscarIdProveedor(int idProducto) {
		
		return productoMapper.findIdProveedor(idProducto);
	}

	
	

}
