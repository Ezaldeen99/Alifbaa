package com.example.android.alifbaa;


import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class CardContainerFragment extends android.app.Fragment {
    private AudioManager.OnAudioFocusChangeListener mAudioFocusListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                // our app is allowed to continue playing sound but at a lower volume. We'll treat
                // both cases the same way because our app is playing short sound files.
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };

    void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
            // Regardless of whether or not we were granted audio focus, abandon it. This also
            // unregisters the AudioFocusChangeListener so we don't get anymore callbacks.
            mAudioManager.abandonAudioFocus(mAudioFocusListener);
        }
    }

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
            int result = mAudioManager.requestAudioFocus(mAudioFocusListener,
                    AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

            if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                // We have audio focus now.

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mMediaPlayer = MediaPlayer.create(getActivity(), AnimalsSounds[position]);

                // Start the audio file
                mMediaPlayer.start();

                // Setup a listener on the media player, so that we can stop and release the
                // media player once the sound has finished playing.
                mMediaPlayer.setOnCompletionListener(mAnimalCompletionListener);
            }
        }
    };
    private MediaPlayer.OnCompletionListener mAnimalCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            flipCard();

        }
    };
    private int position;
    private boolean cardFlipped = false;
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;
    private int[] AnimalsSounds;
    private int[] letterSounds;
    private int[] letters;
    private int[] animals;
    private int[] animalsSpelling;
    private int[] arabicLetterSpelling;
    private int[] englishWords;
    private int[] arabicWords;

    public CardContainerFragment() {
        setHasOptionsMenu(true);
    }

    CardContainerFragment newInstance(int num, int[] AnimalsSounds, int[] letterSounds, int[] letters,
                                      int[] animals, int[] animalsSpelling, int[] arabicLetterSpelling, int[] englishWords
            , int[] arabicWords) {
        CardContainerFragment f = new CardContainerFragment();
        Bundle args = new Bundle();
        args.putInt("image", num);
        args.putIntArray("AnimalsSounds",AnimalsSounds);
        args.putIntArray("letterSounds",letterSounds);
        args.putIntArray("letters",letters);
        args.putIntArray("animals",animals);
        args.putIntArray("animalsSpelling",animalsSpelling);
        args.putIntArray("arabicLetterSpelling",arabicLetterSpelling);
        args.putIntArray("englishWords",englishWords);
        args.putIntArray("arabicWords",arabicWords);
        f.setArguments(args);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        position = getArguments().getInt("image", 0);
        AnimalsSounds = getArguments().getIntArray("AnimalsSounds");
        letterSounds = getArguments().getIntArray("letterSounds");
        letters = getArguments().getIntArray("letters");
        animals = getArguments().getIntArray("animals");
        animalsSpelling = getArguments().getIntArray("animalsSpelling");
        arabicLetterSpelling = getArguments().getIntArray("arabicLetterSpelling");
        englishWords = getArguments().getIntArray("englishWords");
        arabicWords = getArguments().getIntArray("arabicWords");
        View rootView = inflater.inflate(R.layout.fragment_card_container, container, false);
        final int commit = getChildFragmentManager()
                .beginTransaction()
                .add(R.id.container, new CardFrontFragment())
                .commit();
        return rootView;
    }

    public void flipCard() {
        android.app.Fragment newFragment;
        if (cardFlipped) {
            newFragment = new CardFrontFragment();
        } else {
            newFragment = new CardBackFragment();
        }

        getChildFragmentManager()
                .beginTransaction()
                .setCustomAnimations(
                        R.animator.card_flip_right_in, R.animator.card_flip_right_out,
                        R.animator.card_flip_left_in, R.animator.card_flip_left_out)
                .replace(R.id.container, newFragment)
                .commit();

        cardFlipped = !cardFlipped;
    }

    @SuppressLint("ValidFragment")
    public class CardFrontFragment extends android.app.Fragment {

        public CardFrontFragment() {
        }

        private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                // Now that the sound file has finished playing, release the media player resources.
                releaseMediaPlayer();
            }
        };

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_front_layout, container, false);
            ImageView imageView = rootView.findViewById(R.id.image_linear);
            imageView.setImageResource(letters[position]);
            TextView text = rootView.findViewById(R.id.arabic_spelling);
            text.setText(arabicLetterSpelling[position]);
            mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);
            rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    flipCard();
                }
            });
            return rootView;
        }
    }

    @SuppressLint("ValidFragment")
    public class CardBackFragment extends android.app.Fragment {

        public CardBackFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_back_layout, container, false);
            ImageView animalView = rootView.findViewById(R.id.animal_img);
            ImageView spelling = rootView.findViewById(R.id.letter_animal_spelling_img);
            TextView animalArabic = rootView.findViewById(R.id.letter_sound_text);
            animalArabic.setText(arabicWords[position]);
            TextView animalEnglish = rootView.findViewById(R.id.animal_in_english);
            animalEnglish.setText(englishWords[position]);
            animalView.setImageResource(animals[position]);
            spelling.setImageResource(animalsSpelling[position]);
            releaseMediaPlayer();
            int result = mAudioManager.requestAudioFocus(mAudioFocusListener,
                    AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

            if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                // We have audio focus now.

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mMediaPlayer = MediaPlayer.create(getActivity(), letterSounds[position]);

                // Start the audio file
                mMediaPlayer.start();

                // Setup a listener on the media player, so that we can stop and release the
                // media player once the sound has finished playing.
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
            return rootView;
        }
    }

    @Override
    public void onStop() {
        super.onStop();

        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sounds.
        releaseMediaPlayer();
    }
}
