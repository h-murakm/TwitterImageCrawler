package main;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class TwitterImageCrawler {

	public static void main(String[] args) {
		Options options = makeOptions();
		try {
			BasicParser parser = new BasicParser();
			CommandLine cl = parser.parse(options, args);
			String dir = cl.getOptionValue("d");
			String word = cl.getOptionValue("w");
			TwitterAnalyzer ta = new TwitterAnalyzer(dir, word);
			ta.process();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private static Options makeOptions() {
		Options options = new Options();
		Option option_d = OptionBuilder.withArgName("dir").hasArg().isRequired()
				.withDescription("Distination directory").create("d");
		options.addOption(option_d);
		Option option_w = OptionBuilder.withArgName("word").hasArg().isRequired()
				.withDescription("Query word").create("w");
		options.addOption(option_w);
		return options;
	}

	private static void printHelp(Options options) {
		HelpFormatter help = new HelpFormatter();
		help.printHelp(TwitterImageCrawler.class.getName(), options, true);
	}
}
