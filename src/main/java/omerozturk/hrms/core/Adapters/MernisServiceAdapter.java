package omerozturk.hrms.core.Adapters;


import omerozturk.hrms.core.Adapters.KPSPublicSoap.NKUKPSPublicSoap;
import omerozturk.hrms.entities.concretes.Employee;
import org.springframework.stereotype.Service;

@Service
public class MernisServiceAdapter implements CustomerCheckService {
    @Override
    public boolean CheckIfRealPerson(Employee employee) {
        NKUKPSPublicSoap publicSoap = new NKUKPSPublicSoap();

        try {
            return publicSoap.TCKimlikNoDogrula(Long.valueOf(employee.getNationalityIdent()),employee.getFirstName().toUpperCase(),employee.getLastName().toUpperCase(),employee.getBirthDate().getYear());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}