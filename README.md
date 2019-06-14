This project demonstrates a scenario where an error is calling RXJavaPlugins.onError() which prints a stack trace.

This stack trace printing is an blocking IO operation and it is run from a netty event loop thread. 
It in a failure mode, when the http service is returning a lot of errors this can can create a bottleneck slowing down the entire application.  