import LaptopDao;
import TvDao;
import Laptop;
import Tv;
import org.apache.commons.lang3.ArrayUtils;

import java.util.List;
import java.util.Map;

import static by.itclass.constants.AppConst.*;
import static by.itclass.constants.AppConst.PRICE_TO_PARAM;

public class LaptopService implements Service {
    private LaptopDao dao;

    public LaptopService() {
        dao = new LaptopDao();
    }

    public List<Laptop> getLaptops(Map<String, String[]> params) {
        var allLaptops = dao.selectAllLaptop();
        if (params.isEmpty()) {
            return allLaptops;
        }
        var vendors = params.get(VENDOR_PARAM);
        var cpus = params.get(CPU_PARAM);
        var memory = params.get(MEMORY_PARAM);
        var from = params.get(PRICE_FROM_PARAM)[0];
        var to = params.get(PRICE_TO_PARAM)[0];
        return allLaptops.stream()
                .filter(laptop -> vendors == null || ArrayUtils.contains(vendors, laptop.getVendor()))
                .filter(laptop -> cpus == null || ArrayUtils.contains(cpus, laptop.getCpu()))
                .filter(laptop -> memory == null || ArrayUtils.contains(memory, String.valueOf(laptop.getMemorySize())))
                .filter(laptop -> from.isEmpty() || laptop.getPrice() > Double.parseDouble(from))
                .filter(laptop -> to.isEmpty() || laptop.getPrice() < Double.parseDouble(to))
                .toList();
    }
}
