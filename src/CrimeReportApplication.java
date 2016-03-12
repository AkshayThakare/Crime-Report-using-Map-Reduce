import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
public class CrimeReportApplication extends Configured implements Tool{
	public static void main(String[] args) throws Exception {
		int res = ToolRunner.run(new Configuration(),
				new CrimeReportApplication(), args);
		System.exit(res);
	}
	
	@Override
	public int run(String[] args) throws Exception {
		if (args.length != 2) {
			System.out.println("usage: [input] [output]");
			System.exit(-1);
		}
		int exitCode = 0;
		Job job = Job.getInstance(new Configuration());
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);

		job.setMapperClass(CrimeReportMapper.class);
		job.setReducerClass(CrimeReportReducer.class);

		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);

		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		job.setJarByClass(CrimeReportApplication.class);
		exitCode = job.waitForCompletion (true) ? 0 : 1;
		//job.submit();
		return exitCode;
	}
}
