package guru.springframework.converters;

import guru.springframework.commands.CategoryCommand;
import guru.springframework.domain.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryToCategoryCommandTest {

    public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE = 1L;

    CategoryToCategoryCommand converter;

    @Before
    public void setUp() throws Exception {

        converter = new CategoryToCategoryCommand();

    }

    @Test
    public void testNullParameter(){
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject(){
        assertNotNull(converter.convert(new Category()));
    }

    @Test
    public void convert() {
        //given
        Category category = new Category();
        category.setId(LONG_VALUE);
        category.setDescription(DESCRIPTION);


        //when

        CategoryCommand command = converter.convert(category);

        //then

        assertEquals(command.getId(),LONG_VALUE);
        assertEquals(command.getDescription(),DESCRIPTION);
    }
}