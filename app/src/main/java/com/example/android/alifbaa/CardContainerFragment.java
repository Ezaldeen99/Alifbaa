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
    private int position;
    private boolean cardFlipped = false;
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;
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

    private void releaseMediaPlayer() {
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
    private int[] AnimalsSounds = {R.raw.obj_1, R.raw.obj_2, R.raw.obj_3, R.raw.obj_4, R.raw.obj_5, R.raw.obj_6, R.raw.obj_7, R.raw.obj_8,
            R.raw.obj_9, R.raw.obj_10, R.raw.obj_11, R.raw.obj_12, R.raw.obj_13, R.raw.obj_14, R.raw.obj_15, R.raw.obj_16, R.raw.obj_17,
            R.raw.obj_18, R.raw.obj_19, R.raw.obj_20, R.raw.obj_21, R.raw.obj_22, R.raw.obj_23, R.raw.obj_24, R.raw.obj_25, R.raw.obj_26,
            R.raw.obj_27, R.raw.obj_28, R.raw.obj_29, R.raw.obj_30};

    private int[] letterSounds = {R.raw.letter_1, R.raw.letter_2, R.raw.letter_3, R.raw.letter_4, R.raw.letter_5, R.raw.letter_6, R.raw.letter_7, R.raw.letter_8,
            R.raw.letter_9, R.raw.letter_10, R.raw.letter_11, R.raw.letter_12, R.raw.letter_13, R.raw.letter_14, R.raw.letter_15, R.raw.letter_16, R.raw.letter_17,
            R.raw.letter_18, R.raw.letter_19, R.raw.letter_20, R.raw.letter_21, R.raw.letter_22, R.raw.letter_23, R.raw.letter_24, R.raw.letter_25, R.raw.letter_26,
            R.raw.letter_27, R.raw.letter_28, R.raw.letter_29, R.raw.letter_30};

    private int[] letters = {R.drawable.letter_a, R.drawable.letter_b, R.drawable.letter_c, R.drawable.letter_d, R.drawable.letter_e, R.drawable.letter_f,
            R.drawable.letter_g, R.drawable.letter_h, R.drawable.letter_i, R.drawable.letter_j, R.drawable.letter_k, R.drawable.letter_l
            , R.drawable.letter_m, R.drawable.letter_n, R.drawable.letter_o, R.drawable.letter_p, R.drawable.letter_q, R.drawable.letter_r
            , R.drawable.letter_s, R.drawable.letter_t, R.drawable.letter_u, R.drawable.letter_v, R.drawable.letter_w, R.drawable.letter_x
            , R.drawable.letter_y, R.drawable.letter_z, R.drawable.letter_z2, R.drawable.letter_z3, R.drawable.letter_z4, R.drawable.letter_z5};

    private int[] animals = {R.drawable.animal_a, R.drawable.animal_b, R.drawable.animal_c, R.drawable.animal_d, R.drawable.animal_e, R.drawable.animal_f
            , R.drawable.animal_g, R.drawable.animal_h, R.drawable.animal_i, R.drawable.animal_j, R.drawable.animal_k, R.drawable.animal_l
            , R.drawable.animal_m, R.drawable.animal_n, R.drawable.animal_o, R.drawable.animal_p, R.drawable.animal_q, R.drawable.animal_r
            , R.drawable.animal_s, R.drawable.animal_t, R.drawable.animal_u, R.drawable.animal_v, R.drawable.animal_w, R.drawable.animal_x
            , R.drawable.animal_y, R.drawable.animal_z, R.drawable.animal_z2, R.drawable.animal_z3, R.drawable.animal_z4, R.drawable.animal_z5};

    private int[] animalsSpelling = {R.drawable.spelling_a, R.drawable.spelling_b, R.drawable.spelling_c, R.drawable.spelling_d, R.drawable.spelling_e, R.drawable.spelling_f
            , R.drawable.spelling_c, R.drawable.spelling_h, R.drawable.spelling_i, R.drawable.spelling_j, R.drawable.spelling_k, R.drawable.spelling_l
            , R.drawable.spelling_m, R.drawable.spelling_n, R.drawable.spelling_o, R.drawable.spelling_p, R.drawable.spelling_q, R.drawable.spelling_r
            , R.drawable.spelling_s, R.drawable.spelling_t, R.drawable.spelling_u, R.drawable.spelling_v, R.drawable.spelling_w, R.drawable.spelling_x
            , R.drawable.spelling_y, R.drawable.spelling_z, R.drawable.spelling_z2, R.drawable.spelling_z3, R.drawable.spelling_z4, R.drawable.spelling_z5};

    private int[] arabicLetterSpelling = {R.string.alif, R.string.baa, R.string.taa, R.string.thaa, R.string.jeem,
            R.string.haa, R.string.khaa, R.string.daal, R.string.dhall, R.string.raa, R.string.zaa, R.string.seen,
            R.string.sheen, R.string.saad, R.string.dhaad, R.string.taa, R.string.zaa, R.string.ayn, R.string.ghayan,
            R.string.faa, R.string.qaaf, R.string.kaaf, R.string.laam, R.string.meem, R.string.noon, R.string.waaw,
            R.string.haa, R.string.laam_alif, R.string.hamza, R.string.yaa};

    private int[] englishWords = {R.string.rabbit, R.string.duck, R.string.crocodile, R.string.fox, R.string.camel,
            R.string.horse, R.string.sheep, R.string.bear, R.string.housefly, R.string.raccoon, R.string.giraffe,
            R.string.fish, R.string.lion_cub, R.string.hawk, R.string.frog, R.string.peacock, R.string.antelope,
            R.string.spider, R.string.crow, R.string.elephant, R.string.cat, R.string.dog, R.string.strok, R.string.goat,
            R.string.tiger, R.string.rhino, R.string.hoopoe, R.string.llama, R.string.lion, R.string.dragonfly};

    private int[] arabicWords = {R.string.arnab, R.string.batta, R.string.timsah, R.string.thalab, R.string.jamal,
            R.string.hisan, R.string.kharoof, R.string.dob, R.string.thababah, R.string.racoown, R.string.zarraffah,
            R.string.samakah, R.string.shibl, R.string.saqar, R.string.dhafdaah, R.string.tawoos, R.string.dhaby,
            R.string.anacaboot, R.string.goraab, R.string.feel, R.string.qitta, R.string.kalb, R.string.laq_laq,
            R.string.maiz, R.string.namir, R.string.waheed, R.string.hoodhood, R.string.laamaa, R.string.asad, R.string.yassob};

    public CardContainerFragment() {
        setHasOptionsMenu(true);
    }

    CardContainerFragment newInstance(int num) {
        CardContainerFragment f = new CardContainerFragment();
        Bundle args = new Bundle();
        args.putInt("image", num);
        f.setArguments(args);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        position = getArguments().getInt("image", 0);
        View rootView = inflater.inflate(R.layout.fragment_card_container, container, false);
        getChildFragmentManager()
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