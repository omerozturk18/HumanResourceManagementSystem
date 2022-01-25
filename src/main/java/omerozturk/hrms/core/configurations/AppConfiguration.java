package omerozturk.hrms.core.configurations;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import omerozturk.hrms.core.adapters.CloudinaryImageAdapter;
import omerozturk.hrms.core.adapters.ImageService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    @Bean
    public Cloudinary cloudinaryService(){
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name","name",
                "api_key","key",
                "api_secret","secrer"
        ));
    }

    @Bean
    public ImageService imageService(){
        return new CloudinaryImageAdapter(cloudinaryService());
    }
}
