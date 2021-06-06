package omerozturk.hrms.core.adapters;

import omerozturk.hrms.core.utilities.result.DataResult;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    DataResult<?> save (MultipartFile file);

}
