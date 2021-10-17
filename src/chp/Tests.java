package chp;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Tests {
	static void test_input_build_example() {
		var lines = new String[] {
	 		"4",
	 		"abdde",
	 		"ABD",
	 		"DDE",
	 		"AAB",
	 		"ABd",
	 		"A:a,b,c,d,e,f,dd",
	 		"B:a,b,c,d,e,f,dd",
	 		"C:a,b,c,d,e,f,dd",
	 		"D:a,b,c,d,e,f,dd",
	 		"E:aa,bd,c,d,e"
		};
		try {
			var input = Input.buildFromInput(Arrays.stream(lines).collect(Collectors.toList()));
			if (!input.getS().equals("abdde")) 
				throw new RuntimeException("String S loaded incorrectly. Value: " + input.getS());
			if (input.getUnexpandedSubstrings().size() != 4)
				throw new RuntimeException("Wrong number of unexpanded substrings found. Found " + input.getUnexpandedSubstrings().size());
			if (!input.getUnexpandedSubstrings().get(0).equals("ABD"))
				throw new RuntimeException("First unexpanded substring loaded wrongly. Value: " + input.getUnexpandedSubstrings().get(0));
			if (input.getSubsets().size() != 5)
				throw new RuntimeException("Wrong number of subsets found. Found " + input.getSubsets().size());
			if (!input.getSubsets().containsKey('A'))
				throw new RuntimeException("No subset for character A found.");
			var expectedASubset = Arrays.stream(new String[] {"a", "b", "c", "d", "e", "f", "dd"}).collect(Collectors.toList());
			if (!input.getSubsets().get('A').containsAll(expectedASubset))
				throw new RuntimeException("Incorrect subset found for A. Subset: " + input.getSubsets().get('A'));
		} catch (IncorrectInputException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to validate correct input.");
		}
	}
}
