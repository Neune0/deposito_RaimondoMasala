import java.util.stream.Stream;

@FunctionalInterface
interface StreamPocessor {
    Stream<String> process(Stream<String> input);
}

class OldStreamProcessor{
    @Deprecated
    public Stream<String> oldMethod(Stream<String> input){
        return input.map(String::toUpperCase);
    }
}

class MyStreamProcessor extends OldStreamProcessor implements StreamPocessor{
    @Override
    public Stream<String> process(Stream<String> input){
        System.out.println("Override process in MyStreamProcessor");
        return input.filter(s->s.startsWith('C').map(String::toUpperCase););
    }
}

