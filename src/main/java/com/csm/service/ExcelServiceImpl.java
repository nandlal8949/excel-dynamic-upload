package com.csm.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.csm.entity.Student;
import com.csm.service.repository.StudentRepository;
import com.csm.utils.ExcelUtils;

/**
 * By Nandlal git(nandlal8949)
 */
@Service
public class ExcelServiceImpl implements ExcelService {
	@Autowired
	private StudentRepository stRepo;

	@Autowired
	private ExcelUtils exUtil;
	
	@Override
	public String saveData(MultipartFile file) {
		List<List<String>> result = exUtil.getAllDetails(file);
		List<String> excelColumns = result.get(0); // you can see with foreach loop and validate columns and send error.
		
		result.remove(0); // all columns removed
		
		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < result.get(i).size(); j++) {
				//validation for all cell use with if condition
				System.out.printf("%d%d-%s  ", i,j,result.get(i).get(j)); 
				
			}
			System.out.println();
		}
		
		
		List<Student> stList = result.stream().map(t-> new Student(Integer.parseInt(t.get(0)), t.get(1), t.get(2), Integer.parseInt(t.get(3)), t.get(4))).collect(Collectors.toList());
		stRepo.saveAll(stList);
		return "success";
	}

}
