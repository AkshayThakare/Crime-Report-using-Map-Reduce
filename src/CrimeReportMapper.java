import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class CrimeReportMapper extends Mapper<Object, Text, Text, IntWritable>{
	private final static IntWritable one = new IntWritable(1);

	@Override
	public void map(Object key, Text value, Context output) throws IOException, InterruptedException {
			String[] tokens = value.toString().split(",");
			if(tokens.length>=8){
				String east = tokens[4];
				String north = tokens[5];
				if(!east.isEmpty()&&!north.isEmpty()){
					if(!String.valueOf(east.substring(0, 3)).isEmpty()&&!String.valueOf(north.substring(0, 3)).isEmpty()){
						String identifierKey = String.valueOf(east.substring(0, 3))+String.valueOf(north.substring(0, 3))+"::"+tokens[7];
						if(Character.isDigit(identifierKey.charAt(0)))
							output.write(new Text(identifierKey), one);
					}
				}		
			}
	}	
}
