package tech.itpark.avito.manager;

import tech.itpark.avito.domain.Flat;
import tech.itpark.avito.domain.FlatCreat;
import tech.itpark.avito.domain.FlatUpdate;

import java.time.OffsetDateTime;
import java.util.ArrayList;

public class FlatManager {
    private long nextId = 1;

    private ArrayList<Flat> flats = new ArrayList<Flat>();

    public Flat getById(long id) {
        for (Flat flat : flats) {
            if (flat.getId() == id) {
                return flat;
            }
        }

        return null;
    }

    public ArrayList<Flat> getAll() {
        return flats;
    }

    public Flat register(FlatCreat dto) {
        Flat flat = new Flat(
                nextId++,
                "https://www.2amii.org/upmc/2017-S3_JEUDI_PM/BOUCHERKA/retour_page_accueil.png",
                dto.getRooms(),
                dto.getArea(),
                dto.getStorey(),
                dto.getStoreyInHouse(),
                dto.getPrice(),
                dto.getCheck(),
                dto.getComplex(),
                dto.getAddress(),
                dto.getMetro(),
                dto.getDistanceToMetro(),
                dto.getSeller(),
                OffsetDateTime.now().toEpochSecond(),
                false
        );
        flats.add(flat);
        return flat;
    }

    public Flat updateById(long id, FlatUpdate dto) {
        for (Flat flat : flats) {
            if (flat.getId() == id) {
                flat.setImage(dto.getImage());
                flat.setRooms(dto.getRooms());
                flat.setArea(dto.getArea());
                flat.setStorey(dto.getStorey());
                flat.setStoreyInHouse(dto.getStoreyInHouse());
                flat.setPrice(dto.getPrice());
                flat.setCheck(dto.getCheck());
                flat.setComplex(dto.getComplex());
                return flat;

            }

        }

        return null;
    }

    public void removedById(long id) {
        for (Flat flat : flats) {
            if (flat.getId() == id) {
                flat.setRemoved(true);
                return;
            }
        }
    }

    public void restoreById(long id) {
        for (Flat flat : flats) {
            if (flat.getId() == id) {
                flat.setRemoved(false);
                return;
            }
        }
    }

    public ArrayList<Flat> searchBy(String address) {
        ArrayList<Flat> result = new ArrayList<>();

        for (Flat flat : flats) {
            if (flat.getAddress().startsWith(address)) {
                result.add(flat);
            }
        }
        return  result;
    }

    public ArrayList<Flat> searchByMinMaxPrice(int minPrice, int maxPrice) {
        ArrayList<Flat> result = new ArrayList<>();
        for (Flat flat : flats) {
            if (flat.getPrice() >= minPrice && flat.getPrice() <= maxPrice) {
                result.add(flat);
            }
        }
        return result;

    }
}

