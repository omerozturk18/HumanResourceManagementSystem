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
                "cloud_name","omer-mzr25",
                "api_key","724215222779332",
                "api_secret","lGi-6BYGESGK1Kp9NYSslI2yXEo"
        ));
    }

    @Bean
    public ImageService imageService(){
        return new CloudinaryImageAdapter(cloudinaryService());
    }
}