/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import com.findingcareer.pojo.Recruitment;
import java.util.List;
import org.springframework.beans.support.PagedListHolder;

/**
 *
 * @author hp
 */
public class Utils {

    public static PagedListHolder<Recruitment> pagination(List<Recruitment> list, String page, int size){
        PagedListHolder<Recruitment> pagedList = new PagedListHolder<>();
        
        pagedList.setSource(list);
        pagedList.setPageSize(size);
        if(page.equals("prev"))
            pagedList.previousPage();
        else if(page.equals("next"))
            pagedList.nextPage();
        else{
            pagedList.setPage(Integer.parseInt(page) - 1);
        }
        
        return pagedList;
    }
}
