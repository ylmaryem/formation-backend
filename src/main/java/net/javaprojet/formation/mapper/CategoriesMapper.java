
package net.javaprojet.formation.mapper;

import net.javaprojet.formation.dto.CategoriesDto;
import net.javaprojet.formation.entity.Categories;

public class CategoriesMapper {

    public static CategoriesDto mapToCategoriesDto(Categories categories) {
        return new CategoriesDto(
                categories.getNoCategorie(),
                categories.getDesignation(),
                categories.getThemesList()
        );
    }

    public static Categories mapToCategories(CategoriesDto categoriesDto) {
        return new Categories(
                categoriesDto.getNoCategorie(),
                categoriesDto.getDesignation(),
                categoriesDto.getThemesList()
        );
    }
}
