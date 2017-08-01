package com.tubitv.media.fsm.concrete;

import com.google.android.exoplayer2.ExoPlayer;
import com.tubitv.media.fsm.Fsm;
import com.tubitv.media.fsm.Input;
import com.tubitv.media.fsm.State;

/**
 * Created by allensun on 7/27/17.
 */
public class FsmPlayer implements Fsm {

    private ExoPlayer contentPlayer;

    private ExoPlayer adPlayer;

    private State currentState;

    private StateFactory factory;

    public FsmPlayer() {
        factory = new StateFactory();

        /**
         *  initializing state is to make a ad call
         */
        currentState = factory.createState(MakingAdCallState.class);
    }

    @Override
    public State getCurrentState() {
        return currentState;
    }

    @Override
    public void transit(Input input) {
        currentState = currentState.transformToState(input, factory);
    }

    @Override
    public void mainfestToState() {

    }
}
