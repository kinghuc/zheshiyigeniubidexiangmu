/**
 * MIT License

Copyright (c) 2015  Rob Terpilowski

Permission is hereby granted, free of charge, to any person obtaining a copy of this software 
and associated documentation files (the "Software"), to deal in the Software without restriction, 
including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, 
and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, 
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING 
BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, 
WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */


package com.github.misterchangray.libs.bitmex.time;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author RobTerpilowski
 */
public class TimeProvider implements ITimeProvider {

    protected List<TimeUpdatedListener> listeners = new ArrayList<>();
    protected Timer timer = new Timer("Time Provider timer", true);
    
    
    
    @Override
    public void start() {
       // timer.schedule(this, 0, 1000);
    }

    @Override
    public void stop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    @Override
    public void addTimeUpdatedListener(TimeUpdatedListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeTimeUpdatedListener(TimeUpdatedListener listener) {
        listeners.remove(listener);
    }
 
    
    protected void fireTimerEvent() {
        for( TimeUpdatedListener listener : listeners ) {
            listener.timeUpdated(LocalDateTime.now() );
        }
    }
    
    
}
